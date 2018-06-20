package com.weather.Controller;

import com.weather.Config.owmApiConfig;
import com.weather.HttpClient;
import com.weather.Logging;
import com.weather.Model.Forecast;
import com.weather.Model.WeatherDatabaseObject;
import com.weather.Model.WeatherObject;
import com.weather.Service.ForecastServiceInterface;
import com.weather.Service.WeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Collection;
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
        Logging.logger.debug("Weather for: " + city);
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
        try{
            String response = getWeather(currentCity);
        }
        catch(IOException e){
            Logging.logger.debug("Search for: " + city + " failed");
            return "redirect:/";
        }


        //model.addAttribute("city", city);
        model.addAttribute("city", currentWeatherObject.getName() );
        model.addAttribute("description", currentWeatherObject.getWeather().getDescription() );
        model.addAttribute("temp", currentWeatherObject.getMain().getTemp() );
        model.addAttribute("tempmin", currentWeatherObject.getMain().getTemp_min() );
        model.addAttribute("tempmax", currentWeatherObject.getMain().getTemp_max() );
        model.addAttribute("humidity", new String(currentWeatherObject.getMain().getHumidity()+" %") );
        model.addAttribute("pressure", new String(currentWeatherObject.getMain().getPressure()+ " hpa") );
        model.addAttribute("wind", new String(currentWeatherObject.getWind().getSpeed() + " m/s"));
        String icon = "http://openweathermap.org/img/w/" + currentWeatherObject.getWeather().getIcon()+".png";
        model.addAttribute("icon", icon);


        return "weather";
        //return weatherObject.toString();
    }


}

