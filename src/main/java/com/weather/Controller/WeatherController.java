package com.weather.Controller;

import com.weather.Config.owmApiConfig;
import com.weather.HttpClient;
import com.weather.Model.Forecast;
import com.weather.Model.WeatherObject;
import com.weather.Service.ForecastServiceInterface;
import com.weather.Service.WeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;
@RestController
@RequestMapping("/weather")
public class WeatherController {


    @RequestMapping( method = RequestMethod.GET)
    public String getWeather(String city) throws IOException {
        WeatherService service = new WeatherService();
        city = "Warszawa"; // przykładowo test
        WeatherObject weatherObject = service.getActualWeather(city);
        return weatherObject.toString();
    }
}

