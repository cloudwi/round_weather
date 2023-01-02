package com.portfolio.round_weather_backend.domain.weather.repository;

import com.portfolio.round_weather_backend.domain.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

}
