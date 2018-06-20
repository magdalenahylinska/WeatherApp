package com.weather.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public RedirectView newCity(@RequestParam("city") String city, Model model) {
        model.addAttribute("city", city);
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/weather/{city}");
       // return "redirect:/weather";
        return rv;
    }



}