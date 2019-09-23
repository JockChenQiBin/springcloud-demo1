package com.example.springcloudproducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringcloudProducerApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProducerApplication1.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi/{name}")
    public String home(@PathVariable String name){
        return "hi " + name + ",i am from port:" + port;
    }

}
