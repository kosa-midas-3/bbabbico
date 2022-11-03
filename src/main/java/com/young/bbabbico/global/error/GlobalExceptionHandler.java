package com.young.bbabbico.global.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorResponse handleBadRequest(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());

        return ErrorResponse.builder()
                .message(
                        e.getBindingResult().getFieldErrors().get(0).getField() + "의 " +
                                e.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorResponse handleException(Exception e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());

        return new ErrorResponse(e.getMessage());
    }
}