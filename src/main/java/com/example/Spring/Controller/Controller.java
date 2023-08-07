package com.example.Spring.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
 @RequestMapping (value = {"/Home-Page", "/"})  // Getting the same page request
    public String homePage() {

        // What is inversion of control
        // Giving the whole control of how the application will run into the framework

        return "Welcome to home page section";
    }

    // Request Mapping  = Getting the specific address for these methods
    @RequestMapping (value = "/about")
    public String about() {

        return "Welcome to the about page";
    }

    @RequestMapping (value = "/video-games")
    public String videoGames (){
     return "Welcome to Video games section";
    }
}
