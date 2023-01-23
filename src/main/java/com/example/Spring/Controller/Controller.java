package com.example.Spring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class Controller {

    @GetMapping
    private String demoFunc(){
        return "this is a demo get response";
    }
    
}
