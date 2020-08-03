package com.pbb.microserviceconsumermovie.controller;

import com.pbb.microserviceconsumermovie.DO.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/student/{id}")
    public Student findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost:8000/" + id, Student.class);
    }

    /**
     * 查询 microservice-provider-user 服务信息并返回
     * @return microservice-provider-user 服务信息
     */
    @GetMapping("/student-instance")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances("microservice-provider-user");
    }
}