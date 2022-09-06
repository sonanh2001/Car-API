package org.aibles.democar.exception;

import org.springframework.http.HttpStatus;

public class InternalServerError extends BaseException{

  public InternalServerError() {
    setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    setCode("org.aibles.democar.exception.InternalServerError");
  }
}
