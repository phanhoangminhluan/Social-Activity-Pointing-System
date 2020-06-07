package com.edu.fpt.saps.controller.functional_controller;

import com.edu.fpt.saps.constant.ResponseConstant;
import com.edu.fpt.saps.helper.ResponseHelper;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ErrorController extends AbstractErrorController {
    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        return ResponseHelper.builder()
                .isSuccess(false)
                .messages(ResponseConstant.PAGE_NOT_FOUND)
                .body(ResponseConstant.EMPTY_BODY)
                .status(HttpStatus.BAD_REQUEST)
                .build().toResponseEntity();
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
