package com.edu.fpt.saps.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostEventStudentDTO {

    private String token;
    private String email;
    private int eventId;

}
