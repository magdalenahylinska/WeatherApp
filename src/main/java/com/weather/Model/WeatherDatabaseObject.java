package com.weather.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WeatherDatabaseObject {
    public WeatherDatabaseObject() {}

    public WeatherDatabaseObject(WeatherObject weatherObject) {
        dt = weatherObject.getDt();
        windSpeed = weatherObject.getWind().getSpeed();
        cod = weatherObject.getCod();
        visibility = weatherObject.getVisibility();
        name = weatherObject.getName();
        weatherIcon = weatherObject.getWeather().getIcon();
        weatherDescription = weatherObject.getWeather().getDescription();
        weatherMain = weatherObject.getWeather().getMain();
        mainHumidity = weatherObject.getMain().getHumidity();
        mainPressure = weatherObject.getMain().getPressure();
        mainTempMax = weatherObject.getMain().getTemp_max();
        mainTempMin = weatherObject.getMain().getTemp_min();
        temp = weatherObject.getMain().getTemp();
    }

    @Id
    @GeneratedValue
    private String id;

    private String dt;
    private String windSpeed;
    private String cod;
    private String visibility;
    private String name;
    private String weatherIcon;
    private String weatherDescription;
    private String weatherMain;
    private String mainHumidity;
    private String mainPressure;
    private String mainTempMax;
    private String mainTempMin;
    private String temp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getMainHumidity() {
        return mainHumidity;
    }

    public void setMainHumidity(String mainHumidity) {
        this.mainHumidity = mainHumidity;
    }

    public String getMainPressure() {
        return mainPressure;
    }

    public void setMainPressure(String mainPressure) {
        this.mainPressure = mainPressure;
    }

    public String getMainTempMax() {
        return mainTempMax;
    }

    public void setMainTempMax(String mainTempMax) {
        this.mainTempMax = mainTempMax;
    }

    public String getMainTempMin() {
        return mainTempMin;
    }

    public void setMainTempMin(String mainTempMin) {
        this.mainTempMin = mainTempMin;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
