package com.portfolio.round_weather_backend.domain.weather.dto.koreaWeatherApiResponseDto;

public class Response {

    private Header header;
    private Body body;

    public Response() {
    }

    public Response(Header header, Body body) {
        this.header = header;
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Response{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
