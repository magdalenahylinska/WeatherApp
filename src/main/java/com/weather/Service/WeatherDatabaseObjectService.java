package com.weather.Service;

import com.weather.Model.WeatherDatabaseObject;
import com.weather.Repository.WeatherDatabaseObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherDatabaseObjectService {
    private WeatherDatabaseObjectRepository weatherRepository;

    @Autowired
    public void setWeatherRepository(WeatherDatabaseObjectRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public WeatherDatabaseObject saveWeatherDatabaseObject(WeatherDatabaseObject weatherDatabaseObject) {
        return weatherRepository.save(weatherDatabaseObject);
    }
}
