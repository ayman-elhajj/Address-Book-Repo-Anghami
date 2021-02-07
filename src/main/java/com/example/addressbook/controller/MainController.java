package com.example.addressbook.controller;

import com.example.addressbook.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        //Person person = new Person();
        //model.addAttribute("person", person);
        return "new_person";
    }
}