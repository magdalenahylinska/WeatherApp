package com.weather.Controller;

import com.weather.Model.WeatherDatabaseObject;
import com.weather.Service.WeatherDatabaseObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeatherDatabaseObjectController {

    private WeatherDatabaseObjectService weatherService;

    @Autowired
    public void setWeatherService(WeatherDatabaseObjectService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "weatherdata", method = RequestMethod.POST)
    public String saveWeatherDatabaseObject(WeatherDatabaseObject weatherDatabaseObject) {
        weatherService.saveWeatherDatabaseObject(weatherDatabaseObject);
        return "redirect:/WeatherDatabaseObject/" + weatherDatabaseObject.getId();
    }
}
