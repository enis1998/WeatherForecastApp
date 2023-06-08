package com.eniskeskin.weatherforecastapp.service;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class WeatherService {
    private static final String API_TOKEN = "8ea6ac0f3c23e82425d8501ef18465c8";
    private static OpenWeatherMapClient openWeatherClient = new OpenWeatherMapClient(API_TOKEN);

    public String getWeatherByCityName(String cityName) {
        final String weatherJson = openWeatherClient
                .forecast5Day3HourStep()
                .byCityName(cityName)
                .language(Language.TURKISH)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJSON();
        return weatherJson;
    }
}
