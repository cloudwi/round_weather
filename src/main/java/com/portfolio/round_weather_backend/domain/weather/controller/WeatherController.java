package com.portfolio.round_weather_backend.domain.weather.controller;

import com.portfolio.round_weather_backend.domain.weather.dto.WeatherFindAllResponseDto;
import com.portfolio.round_weather_backend.domain.weather.entity.Weather;
import com.portfolio.round_weather_backend.domain.weather.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping()
    public ResponseEntity<List<WeatherFindAllResponseDto>> findAll() {
        List<WeatherFindAllResponseDto> weatherFindAllResponseDtos = new ArrayList<>();
        weatherService.findAll().forEach(weather -> {
            WeatherFindAllResponseDto weatherFindAllResponseDto = new WeatherFindAllResponseDto(weather.isRainCode());
            weatherFindAllResponseDtos.add(weatherFindAllResponseDto);
        });

        return ResponseEntity.ok(weatherFindAllResponseDtos);
    }
}
