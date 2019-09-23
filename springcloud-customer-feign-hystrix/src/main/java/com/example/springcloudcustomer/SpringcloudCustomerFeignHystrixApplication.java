package com.example.springcloudcustomer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.example.springcloudcustomer.feignservice")
public class SpringcloudCustomerFeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudCustomerFeignHystrixApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RoundRobinRule(); 	//轮询策略
    }
}
