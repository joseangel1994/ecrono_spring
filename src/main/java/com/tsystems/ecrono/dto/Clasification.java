package com.tsystems.ecrono.dto;

import java.time.Instant;

import lombok.Data;

@Data
public class Clasification {

    private int dorsalNumber;
    private Long id;
    private String name;
    private Instant timeStamp;
}
