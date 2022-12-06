package com.vinay.microservice.controller;

import com.vinay.microservice.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/user")
    public User user() {
        User user = new User();

        user.setId("1");
        user.setName("Bharath");
        user.setEmailId("bharaththermal@gmail.com");

        return user;
    }

    @GetMapping("/{id}/{id2}")
    public String pathvarible(@PathVariable String id, @PathVariable("id2") String name) {
        return "first variable " + id + ", The second variable " + name;
    }

    @GetMapping("/requestParam")
    public String requestParam(@RequestParam String name, @RequestParam(name = "email", defaultValue = "", required = false) String emailId) {
        return "first param " + name + " second param " + emailId;
    }
}
