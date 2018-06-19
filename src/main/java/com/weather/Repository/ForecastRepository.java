package com.weather.Repository;

import com.weather.Model.Forecast;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ForecastRepository  {
    public static Map<Integer, Forecast> forecast;

    static {
        forecast = new HashMap<Integer, Forecast>() {
            {
                put(1, new Forecast(1, "Krakow"));
                put(2, new Forecast(2, "Warszawa"));
                put(3, new Forecast(3, "Gdańsk"));

            }
        };
    }

    public Collection<Forecast> getAllForecasts(){
        return forecast.values();
    }
}
