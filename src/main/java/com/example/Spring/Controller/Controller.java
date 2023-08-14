package com.example.Spring.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
        public class Controller {

            ArrayList <String> lists = new ArrayList<>(Arrays.asList("Phone", "Laptop", "VGA", "Wifi Router"));
            ArrayList <String> phone = new ArrayList<>(Arrays.asList("Infinix", "Iphone", "Samsung", "Itel"));
            ArrayList <String> Laptop = new ArrayList<>(Arrays.asList("Apple", "Del", "Samsung", "Toshiba"));

            @RequestMapping(value = {"/Home-Page", "/"})  // Getting the same page request
            public String homePage() {

                // What is inversion of control
                // Giving the whole control of how the application will run into the framework

                return "Welcome to home page section";
            }

            // Request Mapping  = Getting the specific address for these methods
            @RequestMapping(value = "/about")
            public String about() {

                return "Welcome to the about page";
            }

            @GetMapping(value = "/video-games")
            public String videoGames() {
                return "Welcome to Video games section";
            }

            @RequestMapping(value = "/Electronics", method = RequestMethod.GET)
                                                            // This specifies the method to be used for the https
            public List<String> normalHomepage(
                    @RequestParam (name = "q", required = false) String q,
                    @RequestParam (name = "age", required = false) String age
            ) {
                return lists;
            }

            @GetMapping(value = "/Electronics/{item}")
            public ArrayList<String> pathVariable(@PathVariable String item) {
                System.out.println(item);
                return null;
            }
        }
