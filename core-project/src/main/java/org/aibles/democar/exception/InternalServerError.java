package org.aibles.democar.exception;

import java.util.HashMap;
import org.aibles.coreexception.exception.BaseException;
import org.springframework.http.HttpStatus;

public class InternalServerError extends BaseException {

  public InternalServerError(HashMap<String, Object> errorMap) {
    super();
    setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    setCode("org.aibles.democar.exception.InternalServerError");
    setErrorMap(errorMap);
  }
}
