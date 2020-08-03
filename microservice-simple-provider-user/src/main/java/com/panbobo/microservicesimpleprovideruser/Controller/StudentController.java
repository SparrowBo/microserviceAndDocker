package com.panbobo.microservicesimpleprovideruser.Controller;

import com.panbobo.microservicesimpleprovideruser.DAO.StudentRepository;
import com.panbobo.microservicesimpleprovideruser.DO.Student;
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
        Student findOne = studentRepository.getOne(stuno);
        return findOne;
    }
}
