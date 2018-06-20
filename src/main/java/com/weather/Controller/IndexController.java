package com.weather.Controller;

import com.weather.Logging;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Homepage controller.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("index", "test");
        return "index";
    }

    @RequestMapping(value = "/newCity")
    public ModelAndView newCity(@RequestParam("city") String city, ModelMap model) {
        model.addAttribute("city", city);
        return new ModelAndView("redirect:/weather/city", model);
    }




}