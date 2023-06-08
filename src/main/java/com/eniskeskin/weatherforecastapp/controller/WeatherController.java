package com.eniskeskin.weatherforecastapp.controller;

import com.eniskeskin.weatherforecastapp.service.UserService;
import com.eniskeskin.weatherforecastapp.service.WeatherService;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class WeatherController {
    private WeatherService weatherService;
    private UserService userService;

    public WeatherController(WeatherService weatherService, UserService userService) {
        this.weatherService = weatherService;
        this.userService = userService;
    }

    @GetMapping("/forecast")
    public String getMappingWeatherByCityName(@RequestParam(value = "cityName") String cityName) {
        final String weatherJson = weatherService.getWeatherByCityName(cityName);
        userService.saveCountry(cityName);
        JSONObject obj = null;
        try {
            obj = new JSONObject(weatherJson);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        //String pageName = obj.getJSONObject("pageInfo").getString("pageName");
        return weatherJson;
    }
}
