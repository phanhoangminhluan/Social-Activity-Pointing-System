package com.edu.fpt.saps.controller.functional_controller;

import com.edu.fpt.saps.constant.ResponseConstant;
import com.edu.fpt.saps.helper.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleEx(Exception ex, WebRequest webRequest) {
        return ResponseHelper.builder()
                .isSuccess(false)
                .messages(ex.getMessage())
                .body(ResponseConstant.EMPTY_BODY)
                .status(HttpStatus.BAD_REQUEST)
                .build().toResponseEntity();
    }
}
