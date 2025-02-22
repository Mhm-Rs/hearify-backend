package com.rxhms.hearify.exception;

import lombok.Getter;

@Getter
public class HearifyNotFoundException extends HearifyException {
  private static final String DEFAULT_CODE = "HEARIFY_NOT_FOUND_PROBLEM";

  public HearifyNotFoundException(String message, Object... args) {
    super(DEFAULT_CODE, message, args);
  }

  public HearifyNotFoundException(String message) {
    super(DEFAULT_CODE, message);
  }
}
