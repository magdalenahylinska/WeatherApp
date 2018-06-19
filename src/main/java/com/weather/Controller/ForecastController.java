package com.weather.Controller;

import com.weather.Model.Forecast;
import com.weather.Service.ForecastServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
@RequestMapping("/forecast")
public class ForecastController {

    @Autowired
    private ForecastServiceInterface forecastServiceInterface;

    @RequestMapping( method = RequestMethod.GET)
    public Collection<Forecast> getAllForecasts(){
        return forecastServiceInterface.getAllForecasts();
    }
}
