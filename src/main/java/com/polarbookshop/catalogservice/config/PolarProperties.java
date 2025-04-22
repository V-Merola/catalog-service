package com.polarbookshop.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "polar")
public class PolarProperties {
    private String greeting;

    public String getgreeting() {
        return greeting;
    }

    public void setgreeting(String greeting) {
        this.greeting = greeting;
    }
}

