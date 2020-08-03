package com.pbb.microservicesimpleconsumermovie.controller;

import com.pbb.microservicesimpleconsumermovie.DO.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/student/{id}")
    public Student findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost:8000/" + id, Student.class);
    }
}
