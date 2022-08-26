package org.aibles.democar.exception;

import java.util.HashMap;
import java.util.Map;

public class BaseException extends RuntimeException {
  private int status;
  private String code;

  private String message;
  private Map<String, Object> params;

  public BaseException() {
    params = new HashMap<>();
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public void addParams(String key, Object value) {
    params.put(key, value);
  }

}
