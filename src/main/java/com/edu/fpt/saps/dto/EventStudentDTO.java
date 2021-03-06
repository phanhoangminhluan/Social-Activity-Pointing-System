package com.edu.fpt.saps.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventStudentDTO {

    private String token;
    private String email;
    private String checkinDate;

}
