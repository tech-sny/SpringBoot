package com.example.Spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring.Entity.Demo;
import com.example.Spring.Repository.DemoRepository;

@RestController
@RequestMapping("/demo")
public class Controller {

    @Autowired
    DemoRepository demoRepository;

    @GetMapping
    private Iterable<Demo> demoFunc(){
        return demoRepository.findAll();
    }
    @PostMapping
    private Demo saveData(@RequestBody Demo request){
        return demoRepository.save(request);
    }
    
}
