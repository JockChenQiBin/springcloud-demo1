package com.example.springcloudcustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringcloudCustomerFeignHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudCustomerFeignHystrixDashboardApplication.class, args);
    }

}
