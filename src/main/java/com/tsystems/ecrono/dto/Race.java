package com.tsystems.ecrono.dto;

import com.tsystems.ecrono.domain.component.RaceType;

import lombok.Data;

@Data
public class Race {

    private Long id;
    private String name;
    private Double distanceInMeters;
    private RaceType type;
    private String initTime;
}
