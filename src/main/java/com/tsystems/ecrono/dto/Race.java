package com.tsystems.ecrono.dto;

import java.time.Instant;

import com.tsystems.ecrono.domain.component.RaceType;

import lombok.Data;

@Data
public class Race {

    private Long id;
    private String name;
    private Double distanceInMeters;
    private RaceType type;
    private Instant initTime;
}
