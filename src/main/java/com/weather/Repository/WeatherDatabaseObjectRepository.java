package com.weather.Repository;

import com.weather.Model.WeatherDatabaseObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDatabaseObjectRepository extends CrudRepository<WeatherDatabaseObject, Integer> {
}
