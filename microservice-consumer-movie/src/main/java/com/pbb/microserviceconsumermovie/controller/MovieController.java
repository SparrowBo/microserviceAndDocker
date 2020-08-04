package com.pbb.microserviceconsumermovie.controller;

import com.pbb.microserviceconsumermovie.DO.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/student/{id}")
    public Student findById(@PathVariable Long id) {
        // 当 eureka 和 ribbon 一起用时，可以用微服务的虚拟主机名！
        return restTemplate.getForObject("http://microservice-provider-user/" + id, Student.class);
    }

    @GetMapping("/log-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        // 打印当前选择的是哪个节点？
        MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(),
                serviceInstance.getHost(), serviceInstance.getPort());
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