package com.weather.Service;

import com.weather.Model.Forecast;
import com.weather.Repository.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ForecastService implements ForecastServiceInterface {




    @Autowired
    private ForecastRepository forecastRepository;
    public Collection<Forecast> getAllForecasts(){
        return forecastRepository.getAllForecasts();
    }
}
