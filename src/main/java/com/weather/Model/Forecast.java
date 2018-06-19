package com.weather.Model;


public class Forecast {

    private int id;
    private String name;

    public Forecast(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Forecast(){}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }


}


