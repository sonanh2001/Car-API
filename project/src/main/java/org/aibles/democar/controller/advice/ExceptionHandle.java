package org.aibles.democar.controller.advice;

import org.aibles.coreexception.controller.advice.BaseExceptionHandle;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle extends BaseExceptionHandle {

  public ExceptionHandle(MessageSource messageSource) {
    super(messageSource);
  }
}
