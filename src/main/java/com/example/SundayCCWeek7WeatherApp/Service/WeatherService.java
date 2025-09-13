package com.example.SundayCCWeek7WeatherApp.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather_api_key}")
    private String apiKey;

    private final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public String getWeatherData(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(API_URL, city, apiKey);
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException.NotFound e) {
            return "{\"error\":\"City not found\"}";
        } catch (Exception e) {
            return "{\"error\":\"An error occurred while fetching weather data.\"}";
        }
    }
}