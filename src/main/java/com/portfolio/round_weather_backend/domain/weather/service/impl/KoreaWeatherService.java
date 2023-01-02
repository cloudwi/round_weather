package com.portfolio.round_weather_backend.domain.weather.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.round_weather_backend.domain.weather.dto.KoreaWeatherApiWrapDto;
import com.portfolio.round_weather_backend.domain.weather.entity.Weather;
import com.portfolio.round_weather_backend.domain.weather.repository.WeatherRepository;
import com.portfolio.round_weather_backend.domain.weather.service.WeatherService;
import com.portfolio.round_weather_backend.domain.weather.webClient.KoreaWeatherWebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class KoreaWeatherService implements WeatherService {

    private final Logger log = LoggerFactory.getLogger(KoreaWeatherService.class);
    private final WebClient webClient;
    private final String serviceKey;
    private final WeatherRepository weatherRepository;

    public KoreaWeatherService(KoreaWeatherWebClient koreaWeatherWebClient, @Value("${secret.serviceKey}") String serviceKey, WeatherRepository weatherRepository) {
        this.webClient = koreaWeatherWebClient.getWebClient();
        this.serviceKey = serviceKey;
        this.weatherRepository = weatherRepository;
    }

    @Scheduled(cron = "* * 0/60 * * ?")
    public void update() {
        log.info("korea weather update");
        LocalDateTime useTime = LocalDateTime.now().minusHours(1);
        String baseDate = useTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String baseTime = useTime.format(DateTimeFormatter.ofPattern("HHmm"));

        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("ServiceKey", serviceKey)
                        .queryParam("pageNo", 1)
                        .queryParam("numOfRows", 1000)
                        .queryParam("dataType", "JSON")
                        .queryParam("base_date", baseDate)
                        .queryParam("base_time", baseTime)
                        .queryParam("nx", 55)
                        .queryParam("ny", 127)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        KoreaWeatherApiWrapDto weatherApiResponseDto = new KoreaWeatherApiWrapDto();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            weatherApiResponseDto = objectMapper.readValue(response, KoreaWeatherApiWrapDto.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        boolean rainCode = Boolean.parseBoolean(weatherApiResponseDto.getResponse().getBody().getItems().getItem().stream().filter(
                item -> item.getCategory().equals("PTY")).findFirst().get().getCategory()
        );

        Weather weather = new Weather(rainCode, "KOREA");

        weatherRepository.deleteAll();
        weatherRepository.save(weather);
    }

    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }
}
