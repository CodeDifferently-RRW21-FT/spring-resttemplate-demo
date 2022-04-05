package com.codedifferently.isithot.domain.weather.repo;

import com.codedifferently.isithot.domain.weather.models.CurrentWeatherResponse;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface CurrentWeatherResponseRepo extends CrudRepository<CurrentWeatherResponse, Long> {
    Optional<CurrentWeatherResponse> findByLatAndLon(String lat, String lon);
}
