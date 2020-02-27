package com.alten.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HelloController {
    @GetMapping("home")
    public String home(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String microServiceName1 = restTemplate.getForEntity("https://alten-challenge-app.herokuapp.com/name", String.class).getBody();
        String microServiceName2 = restTemplate.getForEntity("https://alten-challenge-app-2.herokuapp.com/name", String.class).getBody();
        model.addAttribute("microServiceName1", microServiceName1);
        model.addAttribute("microServiceName2", microServiceName2);
        return "home";
    }
}
