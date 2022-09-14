package org.aibles.democar.exception;

import java.util.HashMap;
import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException{

  public BadRequestException(HashMap<String, Object> errorMap) {
    super();
    setStatus(HttpStatus.BAD_REQUEST.value());
    setCode("org.aibles.democar.exception.BadRequestException");
    setErrorMap(errorMap);
  }
}
