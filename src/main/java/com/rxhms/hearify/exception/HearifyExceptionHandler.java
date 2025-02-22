package com.rxhms.hearify.exception;

import com.rxhms.hearify.exception.dto.ErrorDto;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HearifyExceptionHandler {

  @ExceptionHandler(HearifyNotFoundException.class)
  public ResponseEntity<ErrorDto> handleResourceNotFoundException(HearifyNotFoundException ex) {
    ErrorDto errorResponse =
        ErrorDto.builder().error(ex.code).errorDescription(ex.getMessage()).build();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    errors.put("error", "Illegal Argument(s)");
    ex.getBindingResult()
        .getFieldErrors()
        .forEach(
            error -> {
              errors.put(error.getField(), error.getDefaultMessage());
            });
    return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(HearifyBadRequestException.class)
  public ResponseEntity<ErrorDto> handleBadRequestException(HearifyBadRequestException ex) {
    ErrorDto errorResponse =
        ErrorDto.builder().error(ex.code).errorDescription(ex.getMessage()).build();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }
}
