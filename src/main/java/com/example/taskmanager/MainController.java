package com.example.taskmanager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping("/")
    public String greet(){
        return "Welcome let's do some tasks";
    }
}
