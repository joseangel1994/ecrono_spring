package com.tsystems.ecrono.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

public class User {

    private Long id;

    @JsonProperty("user_name")
    private String userName;

    private Set<String> role;
}
