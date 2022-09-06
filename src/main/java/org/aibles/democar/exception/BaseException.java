package org.aibles.democar.exception;

import java.util.HashMap;
import java.util.Map;

public class BaseException extends RuntimeException {
  private int status;
  private String code;

  private Map<String, Object> params;

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

  public Map<String, Object> getParams() {
    return params;
  }

  public void addParams(String key, Object value) {
    if(params == null) {
      params = new HashMap<>();
    }
    params.put(key, value);
  }
}
