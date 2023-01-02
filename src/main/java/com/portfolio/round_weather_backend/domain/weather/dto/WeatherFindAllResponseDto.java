package com.portfolio.round_weather_backend.domain.weather.dto;

public class WeatherFindAllResponseDto {
    private boolean rainCode;

    public WeatherFindAllResponseDto(boolean rainCode) {
        this.rainCode = rainCode;
    }

    public boolean isRainCode() {
        return rainCode;
    }
}
