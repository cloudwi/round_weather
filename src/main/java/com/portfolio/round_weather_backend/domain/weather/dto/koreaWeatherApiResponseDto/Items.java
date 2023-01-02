package com.portfolio.round_weather_backend.domain.weather.dto.koreaWeatherApiResponseDto;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private List<Item> item = new ArrayList<>();

    public Items() {
    }

    public List<Item> getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Items{" +
                "item=" + item +
                '}';
    }
}
