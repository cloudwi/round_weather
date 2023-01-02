package com.portfolio.round_weather_backend.domain.weather.dto.koreaWeatherApiResponseDto;

public class Header {
    private String resultCode;
    private String resultMsg;

    public Header() {
    }

    public Header(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    @Override
    public String toString() {
        return "Header{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
