package com.weather.Config;

public class owmApiConfig {
    static private String owmKey = "cc2f2862c9e5a8ebbe7750e9007813f7";
    static private String owmUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static String getUrl() { return owmUrl; }
    public static String getKey() {
        return owmKey;
    }
}
