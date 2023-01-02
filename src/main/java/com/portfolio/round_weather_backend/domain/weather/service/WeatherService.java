package com.portfolio.round_weather_backend.domain.weather.service;

import com.portfolio.round_weather_backend.domain.weather.entity.Weather;

import java.util.List;

public interface WeatherService {

    void update();
    List<Weather> findAll();
}
