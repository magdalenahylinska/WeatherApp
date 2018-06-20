package com.weather.Service;

import com.weather.Config.owmApiConfig;
import com.weather.HttpClient;
import com.weather.Model.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class WeatherService  {

    @Autowired
    public WeatherService()
    {}

    public WeatherObject getActualWeather(String city) throws IOException {
        JSONObject json = HttpClient.sendRequest(owmApiConfig.getUrl(), city, owmApiConfig.getKey());
        WeatherObject weatherObject = this.JSONToWeatherObject(json);
        return weatherObject;
    }

    private WeatherObject JSONToWeatherObject(JSONObject json)
    {
        Weather weatherComponent = new Weather(
                Integer.toString(json.getJSONArray("weather").getJSONObject(0).getInt("id")),
                json.getJSONArray("weather").getJSONObject(0).getString("icon"),
                json.getJSONArray("weather").getJSONObject(0).getString("description"),
                json.getJSONArray("weather").getJSONObject(0).getString("icon")
        );
        Wind windComponent = new Wind(
                Double.toString(json.getJSONObject("wind").getDouble("speed"))
        );
        MainComponent mainComponent = new MainComponent(
                Double.toString(json.getJSONObject("main").getDouble("humidity")),
                Double.toString(json.getJSONObject("main").getDouble("pressure")),
                Double.toString(json.getJSONObject("main").getDouble("temp_max")),
                Double.toString(json.getJSONObject("main").getDouble("temp_min")),
                Double.toString(json.getJSONObject("main").getDouble("temp"))
        );
        WeatherObject weatherObject = new WeatherObject(
                Integer.toString(json.getInt("id")),
                Integer.toString(json.getInt("dt")),
                windComponent,
                Integer.toString(json.getInt("cod")),
                Integer.toString(json.getInt("visibility")),
                json.getString("name"),
                weatherComponent,
                mainComponent
        );

        return weatherObject;
    }
}