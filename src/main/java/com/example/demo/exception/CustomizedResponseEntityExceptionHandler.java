package com.example.demo.exception;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResponseStatusException.class)
  public final ResponseEntity<BaseResponse> handleAllExceptions(ResponseStatusException ex, WebRequest request) {
    BaseResponse baseResponse = new BaseResponse();
    baseResponse.setMessage(ex.getReason());
    return new ResponseEntity<>(baseResponse, ex.getStatus());
  }
}