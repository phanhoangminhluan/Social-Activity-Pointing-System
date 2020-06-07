package com.edu.fpt.saps.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
@EqualsAndHashCode
public class EventStudentId implements Serializable {

    @Column(name = "email")
    private String email;

    @Column(name = "event_id")
    private int eventId;

}
