package com.codedifferently.isithot.domain.weather.service;

import com.codedifferently.isithot.domain.weather.models.CurrentWeatherResponse;

public interface WeatherService {
    CurrentWeatherResponse requestWeather(String lat, String lon);
    CurrentWeatherResponse save(CurrentWeatherResponse response);
    Iterable<CurrentWeatherResponse> findAll();
}
