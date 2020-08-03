package com.pbb.microserviceprovideruser.controller;

import com.pbb.microserviceprovideruser.DAO.StudentRepository;
import com.pbb.microserviceprovideruser.DO.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/{stuno}")
    public Student findById(@PathVariable Long stuno) {
        Student one = studentRepository.getOne(stuno);
        return one;
    }
}
