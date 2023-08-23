package com.example.Spring.Controller;

import com.example.Spring.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
        public class Controller {

            ArrayList <String> lists = new ArrayList<>(Arrays.asList("Phone", "Laptop", "VGA", "Wifi Router"));
            ArrayList <String> phone = new ArrayList<>(Arrays.asList("Infinix", "Iphone", "Samsung", "Itel"));
            ArrayList <String> Laptop = new ArrayList<>(Arrays.asList("Apple", "Del", "Samsung", "Toshiba"));

            ArrayList <User> users = new ArrayList<User>();


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
            public ArrayList<String> multiplePathVariable(@PathVariable String item) {
                System.out.println(item);
                if(item.equalsIgnoreCase("phone")) {
                    return phone;
                }
                if (item.equalsIgnoreCase("laptop")) {
                    return Laptop;
                }
                return null;

            }
            @GetMapping("/electronic-pages/{item}")
            public ResponseEntity<Object> pathVariable(@PathVariable String item) {
        System.out.println(item);
        ResponseEntity<Object> responseEntity = new ResponseEntity(item + "Not Found",HttpStatus.NOT_FOUND);
        if(item.equalsIgnoreCase("phone")) {
            return ResponseEntity.ok(phone);
        }
        if (item.equalsIgnoreCase("laptop")) {
            return ResponseEntity.ok(Laptop);
        }
        return null;

        }

          @PostMapping("/register")
          public ResponseEntity<?> register(@RequestBody User user) {
              System.out.println(user);

              for (User currentUser:users){
                  if (user.getPhone().equals(currentUser.getPhone())) {
                      return new ResponseEntity<>("Phone Number Already used",HttpStatus.BAD_REQUEST);
                  }
              }
              int id = users.size() + 1;
              user.setId(id);
              users.add(user);
                return ResponseEntity.ok("Registered Successfully");
          }

          @GetMapping ("/users")
    public ResponseEntity<?> user (){
                return ResponseEntity.ok(users);
          }
        }
