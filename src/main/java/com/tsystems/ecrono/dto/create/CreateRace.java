package com.tsystems.ecrono.dto.create;

import java.time.Instant;

import lombok.Data;

@Data
public class CreateRace {

    private Long id;
    private String name;
    private Double distanceInMeters;
    private Instant initTime;
}
