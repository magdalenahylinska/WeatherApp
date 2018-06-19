package com.weather.Service;

import com.weather.Model.Forecast;
import java.util.Collection;

public interface ForecastServiceInterface {
     Collection<Forecast> getAllForecasts();
}
