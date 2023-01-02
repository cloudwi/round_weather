package com.portfolio.round_weather_backend.domain.weather.webClient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Component
public class KoreaWeatherWebClient {

    private WebClient webClient;

    public KoreaWeatherWebClient() {
        String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";

        DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory(BASE_URL);
        defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        this.webClient = WebClient.builder()
                .uriBuilderFactory(defaultUriBuilderFactory)
                .baseUrl(BASE_URL)
                .build();
    }

    public WebClient getWebClient() {
        return webClient;
    }
}
