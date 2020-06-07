package com.edu.fpt.saps.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "event_student")
public class EventStudent {


    @EmbeddedId
    private EventStudentId eventStudentId;

    @Column(name = "checkin_date")
    private String checkinDate;

    @Column(name = "token")
    private String token;
}
