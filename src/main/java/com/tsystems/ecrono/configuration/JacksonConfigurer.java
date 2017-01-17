package com.tsystems.ecrono.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

//Esta clase se va a usar para configurar un Bean de Spring
@Configuration
public class JacksonConfigurer {

    @Bean // Este metodo es un metodo que crea un Bean
    public ObjectMapper getObjectMapper(@Autowired Jackson2ObjectMapperBuilder builder) {

	ObjectMapper objectMapper = builder.build();
	objectMapper.registerModule(new JavaTimeModule());
	// objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
	// false);
	return objectMapper;
    }
}
