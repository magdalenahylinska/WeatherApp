package com.weather.Model;

public class Wind {

    public Wind(String _speed)
    {
        this.speed = _speed;
    }

    private String speed;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}