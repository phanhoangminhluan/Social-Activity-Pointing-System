package com.edu.fpt.saps.dto;

import com.edu.fpt.saps.constant.ResponseConstant;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO {
    private boolean isSuccess;
    private String messages;
    private Object body;

    public static ResponseEntity generateResponseObject(Boolean isSuccess, String messages, Object body, HttpStatus status) {
        ResponseDTO responseDTO =  ResponseDTO.builder()
                .isSuccess(isSuccess)
                .messages(messages)
                .body(body)
                .build();
        ResponseEntity responseEntity = new ResponseEntity<>(responseDTO, status);
        return responseEntity;
    }
}