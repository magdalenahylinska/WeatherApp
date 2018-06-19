package com.weather.Model;

import com.weather.Main;

public class WeatherObject
{
    public WeatherObject(String _id, String _dt, Wind _wind, String _cod, String _visibility, String _name, Weather _weather, MainComponent _main)
    {
        this.id = _id;
        this.dt = _dt;
        this.wind = _wind;
        this.cod = _cod;
        this.visibility = _visibility;
        this.name = _name;
        this.weather = _weather;
        this.main = _main;
    }

    private String id;

    private String dt;

    private Wind wind;

    private String cod;

    private String visibility;

    private String name;

    private Weather weather;

    private MainComponent main;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public Wind getWind ()
    {
        return wind;
    }

    public void setWind (Wind wind)
    {
        this.wind = wind;
    }

    public String getCod ()
    {
        return cod;
    }

    public void setCod (String cod)
    {
        this.cod = cod;
    }

    public String getVisibility ()
    {
        return visibility;
    }

    public void setVisibility (String visibility)
    {
        this.visibility = visibility;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }


    public Weather getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather weather)
    {
        this.weather = weather;
    }

    public MainComponent getMain ()
    {
        return main;
    }

    public void setMain (MainComponent main)
    {
        this.main = main;
    }

    @Override
    public String toString()
    {
        return "Pogoda w " + getName() + ": Srednia temperatura = " + getMain().getTemp() + " stopni";
    }
}



