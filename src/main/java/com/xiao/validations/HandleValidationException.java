package com.xiao.validations;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.PushBuilder;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HandleValidationException  {
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        //return super.handleMethodArgumentNotValid(ex, headers, status, request);
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", new Date());
//        body.put("status", status.value());
//
//        //Get all errors
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(x -> x.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        body.put("errors", errors);
//
//        return new ResponseEntity<>(body, headers, status);
//
//    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handle(MethodArgumentNotValidException ex) {
        Map<String, String> err = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(item -> {
            err.put(item.getField(),item.getDefaultMessage());
        });
        return err;
    }

    @ExceptionHandler(UserNotFindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> userNotFound(UserNotFindException ex) {
        Map<String, String> err = new HashMap<>();
        err.put("error", ex.getLocalizedMessage());
        return  err;
    }

}
