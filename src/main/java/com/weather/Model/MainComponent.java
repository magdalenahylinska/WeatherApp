package com.weather.Model;

public class MainComponent {

    public MainComponent(String _humidity, String _pressure, String _temp_max, String _temp_min, String _temp)
    {
        this.humidity = _humidity;
        this.pressure = _pressure;
        this.temp_max = _temp_max;
        this.temp_min = _temp_min;
        this.temp = _temp;
    }
    private String humidity;

    private String pressure;

    private String temp_max;

    private String temp_min;

    private String temp;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}