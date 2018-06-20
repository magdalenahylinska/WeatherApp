package com.weather.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Weather
{
    public Weather() {}

    public Weather(String _id, String _icon, String _description, String _main)
    {
        this.id = _id;
        this.icon = _icon;
        this.description = _description;
        this.main = _main;
    }

    private String id;

    private String icon;

    private String description;

    private String main;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getMain ()
    {
        return main;
    }

    public void setMain (String main)
    {
        this.main = main;
    }
}