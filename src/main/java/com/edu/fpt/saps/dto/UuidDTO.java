package com.edu.fpt.saps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UuidDTO {

    private String uuid;
    public static UuidDTO generateUUID() {
        return new UuidDTO(UUID.randomUUID().toString());
    }
}
