package com.codedifferently.isithot.domain.weather.controllers;

import com.codedifferently.isithot.domain.weather.models.CurrentWeather;
import com.codedifferently.isithot.domain.weather.models.CurrentWeatherResponse;
import com.codedifferently.isithot.domain.weather.service.WeatherService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
@Slf4j
public class WeatherController {
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<CurrentWeatherResponse>> getAll(){
        Iterable<CurrentWeatherResponse> all = weatherService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<CurrentWeatherResponse> requestWeather(@RequestParam(name="lon", required = false) String lon,
                                                                 @RequestParam(name="lat", required = false) String lat){
        CurrentWeatherResponse response = response = weatherService.requestWeather(lat, lon);
        log.info(response.toString());
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
