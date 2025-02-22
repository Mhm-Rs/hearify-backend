package com.rxhms.hearify.exception;

import lombok.Getter;

@Getter
public class HearifyBadRequestException extends HearifyException {
  private static final String DEFAULT_CODE = "HEARIFY_BAD_REQUEST_PROBLEM";

  public HearifyBadRequestException(String message, Object... args) {
    super(DEFAULT_CODE, message, args);
  }

  public HearifyBadRequestException(String message) {
    super(DEFAULT_CODE, message);
  }
}
