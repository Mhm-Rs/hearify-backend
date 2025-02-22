package com.rxhms.hearify.exception;

import java.text.MessageFormat;

public abstract class HearifyException extends RuntimeException {
  protected final String code;

  protected HearifyException(String code, String message, Object... args) {
    super(formatMessage(message, args));
    this.code = code;
  }

  protected HearifyException(String code, String message) {
    super(message);
    this.code = code;
  }

  private static String formatMessage(String message, Object... args) {
    final MessageFormat messageFormat = new MessageFormat(message);
    return messageFormat.format(args);
  }
}
