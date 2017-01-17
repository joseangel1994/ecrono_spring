package com.tsystems.ecrono.dto.update;

import java.time.Instant;

import lombok.Data;

@Data
public class UpdateRace {

    private Long id;
    private String name;
    private Double distanceInMeters;
    private Instant initTime;
}
