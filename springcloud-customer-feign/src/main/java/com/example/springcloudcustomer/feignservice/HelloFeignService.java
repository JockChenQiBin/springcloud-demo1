package com.example.springcloudcustomer.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: chenqibin
 * @Date: 2019/8/23 16:03
 * @Description:
 */
@Service
@FeignClient("microservice-hi-provider")
public interface HelloFeignService {

    @RequestMapping(value = "/hi/{name}", method = RequestMethod.GET)
    String hi(@PathVariable("name") String name);

}
