package com.weather.Repository;

import com.weather.Model.WeatherDatabaseObject;
import org.springframework.data.repository.CrudRepository;

public interface WeatherDatabaseObjectRepository extends CrudRepository<WeatherDatabaseObject, Integer> {
}
