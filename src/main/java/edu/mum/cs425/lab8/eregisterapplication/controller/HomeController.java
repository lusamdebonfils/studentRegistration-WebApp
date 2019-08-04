package edu.mum.cs425.lab8.eregisterapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/eregister","/eregister/index","/eregister/home"})
    public String displayMainPage(){
        return "index";
    }

}
