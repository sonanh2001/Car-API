package org.aibles.democar.exception;

import static org.aibles.democar.constants.ExceptionConstants.CAR_NOT_FOUND_CODE;
import static org.aibles.democar.constants.ExceptionConstants.NOT_FOUND_STATUS;

public class CarNotFoundException extends BaseException {

  public CarNotFoundException(long id) {
    super();
    setStatus(NOT_FOUND_STATUS);
    setCode(CAR_NOT_FOUND_CODE);
    addParams("id", id);
    setMessage("Can't find the car have id: " + getParams().get("id"));
  }
}
