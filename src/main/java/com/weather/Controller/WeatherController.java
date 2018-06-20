package com.weather.Controller;

import com.weather.Model.WeatherDatabaseObject;
import com.weather.Model.WeatherObject;
import com.weather.Service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
@Controller

public class WeatherController {


//    @RequestMapping( method = RequestMethod.GET)
//    public String getWeather(String city, Model model) throws IOException {
//        WeatherService service = new WeatherService();
//        city = "Warszawa"; // przykładowo test
//        WeatherObject weatherObject = service.getActualWeather(city);
//        model.addAttribute("data", weatherObject.toString());
//        return "data";
//        //return weatherObject.toString();
//    }
    WeatherObject currentWeatherObject;
    String currentCity;

    public WeatherController(){
        currentCity="Warszawa";
    }

    public WeatherController(String city){
        currentCity=city;
    }


    public String getWeather(String city) throws IOException {
        WeatherService service = new WeatherService();

        //city = "Warszawa"; // przykładowo test
        currentWeatherObject = service.getActualWeather(city);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pawlikow");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        WeatherDatabaseObject tmp = new WeatherDatabaseObject(currentWeatherObject);

        entityManager.getTransaction().begin();
        entityManager.persist(tmp);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return currentWeatherObject.toString();
    }

    @RequestMapping("/weather/{city}")
    public String currentWeather(@RequestParam("city") String city, Model model) throws IOException {
        currentCity=city;
        String response = getWeather(currentCity);

        model.addAttribute("city", city);
        //model.addAttribute("name", currentWeatherObject.getName() );
        model.addAttribute("description", currentWeatherObject.getWeather().getDescription() );
        model.addAttribute("temp", currentWeatherObject.getMain().getTemp() );
        model.addAttribute("tempmin", currentWeatherObject.getMain().getTemp_min() );
        model.addAttribute("tempmax", currentWeatherObject.getMain().getTemp_max() );
        model.addAttribute("humidity", currentWeatherObject.getMain().getHumidity() );
        model.addAttribute("wind", currentWeatherObject.getWind().getSpeed() );
        String icon = "http://openweathermap.org/img/w/" + currentWeatherObject.getWeather().getIcon()+".png";
        model.addAttribute("icon", icon);


        return "weather";
        //return weatherObject.toString();
    }
}

