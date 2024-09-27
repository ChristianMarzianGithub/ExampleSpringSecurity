package com.example.demo.controller;

import com.example.demo.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @GetMapping("/getExample")
    public String getExample(){
        authoritiesRepository.findAll().forEach(authority -> System.out.println(authority.getNAME()));

        return "Welcome to /getExample";
    }
}