package com.tsystems.ecrono.dto.create;

import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CreateUser {

    @NotEmpty // Anotacion de validacion
    @JsonProperty("user_name")
    private String userName;
    @NotEmpty
    private String password;
    @NotEmpty
    private Set<String> role;
}
