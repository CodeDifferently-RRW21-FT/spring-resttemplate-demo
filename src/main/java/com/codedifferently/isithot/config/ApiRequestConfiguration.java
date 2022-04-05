package com.codedifferently.isithot.config;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Log
public class ApiRequestConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        log.info("Creating bean for rest template");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
