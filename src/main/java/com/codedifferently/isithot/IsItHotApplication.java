package com.codedifferently.isithot;

import com.codedifferently.isithot.domain.weather.models.CurrentWeatherResponse;
import com.codedifferently.isithot.domain.weather.service.WeatherService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class IsItHotApplication {

    public static void main(String[] args) {
        SpringApplication.run(IsItHotApplication.class, args);
    }

    @Autowired
    private WeatherService weatherService;


}
