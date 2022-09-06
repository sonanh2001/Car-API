package org.aibles.democar.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democar.exception.InternalServerError;

@Slf4j
public class ModelValidator<T> {
  private static final Validator validator =
      Validation.buildDefaultValidatorFactory().getValidator();
  public void isValid() {
    var violations = validator.validate(this);
    if(!violations.isEmpty()) {
      log.error("(isValid){} --> INVALID", this.getClass().getName());
      for (var violation : violations) {
        log.info("(isValid){} : {}", this.getField(violation), violation.getMessage());
      }
      throw new InternalServerError();
    }
  }

  private String getField(ConstraintViolation<ModelValidator<T>> violation) {
    return violation.getPropertyPath().toString();
  }
}
