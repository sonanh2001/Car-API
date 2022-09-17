package org.aibles.democar.validation;

import java.util.HashMap;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democar.exception.BadRequestException;
import org.aibles.democar.exception.InternalServerError;

@Slf4j
public class ModelValidator<T> {
  private static final Validator validator =
      Validation.buildDefaultValidatorFactory().getValidator();

  public void isValid() {
    var violations = validator.validate(this);
    if (!violations.isEmpty()) {
      log.error("(isValid){} --> INVALID", this.getClass().getName());
      HashMap<String, Object> errorMap = new HashMap<>();
      for (var violation : violations) {
        log.info("(isValid){} : {}", this.getField(violation), violation.getMessage());
        errorMap.put(this.getField(violation), violation.getMessage());
      }
      if (this.getClass().getName().toLowerCase().contains("request")) {
        throw new BadRequestException(errorMap);
      } else {
        throw new InternalServerError(errorMap);
      }
    }
  }

  private String getField(ConstraintViolation<ModelValidator<T>> violation) {
    return violation.getPropertyPath().toString();
  }
}
