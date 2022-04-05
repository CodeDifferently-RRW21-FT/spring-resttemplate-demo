package com.codedifferently.isithot.domain.weather.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@ToString
@Entity
public class CurrentWeatherResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private CurrentWeatherSys sys;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CurrentWeather> weather;

    @Transient
    @JsonBackReference
    private Map<String, String> coord;

    private String lon;

    private String lat;
}
