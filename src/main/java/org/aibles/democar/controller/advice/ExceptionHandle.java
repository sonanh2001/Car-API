package org.aibles.democar.controller.advice;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democar.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandle {
  @ExceptionHandler(BaseException.class)
  public ResponseEntity<Map<String, Object>> handle(BaseException ex) {
    log.info("(handle)exception : {}", ex.getCode());
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("status", ex.getStatus());
    errorMap.put("code", ex.getCode());
    errorMap.put("message", ex.getMessage());
    return ResponseEntity.status(HttpStatus.valueOf(ex.getStatus())).body(errorMap);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handle(MethodArgumentNotValidException ex) {
    log.info("(handle)exception: {}", ex.getClass().getName());
    Map<String, String> errorMap = new HashMap<>();
    ex.getBindingResult()
        .getFieldErrors()
        .forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
  }
}
