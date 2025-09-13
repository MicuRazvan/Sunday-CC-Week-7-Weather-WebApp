package com.example.SundayCCWeek7WeatherApp.Controller;

import com.example.SundayCCWeek7WeatherApp.Service.WeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String index() {
        return "weather";
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {
        //if somehow city is null we just refresh the page
        if (city == null || city.trim().isEmpty()) {
            return "weather";
        }

        String weatherData = weatherService.getWeatherData(city);
        JSONObject jsonObject = new JSONObject(weatherData);

        if (jsonObject.has("error")) {
            model.addAttribute("error", jsonObject.getString("error"));
        } else {
            model.addAttribute("city", jsonObject.getString("name"));
            JSONObject main = jsonObject.getJSONObject("main");
            model.addAttribute("temperature", main.getDouble("temp"));
            model.addAttribute("humidity", main.getInt("humidity"));
            String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
            model.addAttribute("description", description);
        }
        return "weather";
    }
}