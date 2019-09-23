package com.example.springcloudproducer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RestController
public class SpringcloudProducerHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProducerHystrixApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi/{name}")
    @HystrixCommand(fallbackMethod="hystrixHome") //一旦服务调用失败，就调用hystrixHome方法
    public String home(@PathVariable String name){
        if(name.equals("hystrix")){
            throw new RuntimeException("hystrix test exception!");
        }
        return "hi " + name + ",i am from port:" + port;
    }

    public String hystrixHome(@PathVariable String name){
        return "因传入name参数为hystrix，故提供服务失败！熔断成功！";
    }

}
