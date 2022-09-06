package org.aibles.democar.exception;


import org.springframework.http.HttpStatus;

public class CarNotFoundException extends BaseException {

  public CarNotFoundException(long id) {
    super();
    setStatus(HttpStatus.NOT_FOUND.value());
    setCode("org.aibles.democar.exception.CarNotFoundException");
    addParams("id", id);
  }
}
