package com.portfolio.round_weather_backend.domain.weather.entity;

import com.portfolio.round_weather_backend.global.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class Weather extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private boolean rainCode;

    @Column(nullable = false)
    private String meteorological;

    public Weather() {

    }

    public Weather(boolean rainCode, String meteorological) {
        this.rainCode = rainCode;
        this.meteorological = meteorological;
    }

    public boolean isRainCode() {
        return rainCode;
    }

    public String getMeteorological() {
        return meteorological;
    }
}
