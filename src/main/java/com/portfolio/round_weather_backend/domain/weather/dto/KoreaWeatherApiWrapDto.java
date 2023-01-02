package com.portfolio.round_weather_backend.domain.weather.dto;

import com.portfolio.round_weather_backend.domain.weather.dto.koreaWeatherApiResponseDto.Response;

public class KoreaWeatherApiWrapDto {
    private Response response;

    public KoreaWeatherApiWrapDto() {
    }

    public KoreaWeatherApiWrapDto(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "WeatherApiWrapDto{" +
                "response=" + response +
                '}';
    }
}
