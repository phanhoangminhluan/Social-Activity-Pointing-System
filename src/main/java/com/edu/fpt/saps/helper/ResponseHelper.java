package com.edu.fpt.saps.helper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseHelper {
    private boolean isSuccess;
    private String messages;
    private Object body;
    @JsonIgnore
    private HttpStatus status;

    public ResponseEntity toResponseEntity() {
        ResponseHelper responseHelper =  ResponseHelper.builder()
                .isSuccess(isSuccess)
                .messages(messages)
                .body(body)
                .build();
        ResponseEntity responseEntity = new ResponseEntity<>(responseHelper, status);
        return responseEntity;
    }
}