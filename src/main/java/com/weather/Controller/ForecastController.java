package com.weather.Controller;

import com.weather.HttpClient;
import com.weather.Logging;
import com.weather.Main;
import com.weather.Model.Forecast;
import com.weather.Service.ForecastService;
import com.weather.Service.ForecastServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        Logging.logger.debug("GET ALL FORECASTS");
        return forecastServiceInterface.getAllForecasts();
    }


}
