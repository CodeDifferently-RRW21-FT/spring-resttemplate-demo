package com.codedifferently.isithot.domain.weather.service;

import com.codedifferently.isithot.domain.weather.models.CurrentWeatherResponse;
import com.codedifferently.isithot.domain.weather.repo.CurrentWeatherResponseRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService{
    private RestTemplate restTemplate;
    private CurrentWeatherResponseRepo responseRepo;

    public WeatherServiceImpl(RestTemplate restTemplate, CurrentWeatherResponseRepo responseRepo){
        this.restTemplate = restTemplate;
        this.responseRepo = responseRepo;
    }

    public CurrentWeatherResponse requestWeather(String lat, String lon){
        Optional<CurrentWeatherResponse> optional = responseRepo.findByLatAndLon(lat, lon);
        CurrentWeatherResponse currentWeather;
        if(optional.isEmpty()){
            log.info("Do not have this local, looking externally");
            currentWeather = requestDataFromExtenal(lat,lon);
            Map<String, String> coord = currentWeather.getCoord();
            currentWeather.setLat(coord.get("lat"));
            currentWeather.setLon(coord.get("lon"));
        }else {
            currentWeather = optional.get();
            log.info("Found data locally, i just saved with Gieco");
        }
        return responseRepo.save(currentWeather);
    }

    private CurrentWeatherResponse requestDataFromExtenal(String lat, String lon){
        String uri = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=02d89c111f6d38ab228027d7e9a49a62", lat, lon);
        ResponseEntity<CurrentWeatherResponse> response = restTemplate.exchange(uri, HttpMethod.GET,null, CurrentWeatherResponse.class);
        CurrentWeatherResponse currentWeather = response.getBody();
        return currentWeather;
    }

    @Override
    public CurrentWeatherResponse save(CurrentWeatherResponse response) {
        return responseRepo.save(response);
    }

    @Override
    public Iterable<CurrentWeatherResponse> findAll() {
        return responseRepo.findAll();
    }
}
