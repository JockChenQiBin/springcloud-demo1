package com.example.springcloudcustomer.fallbackFactory;

import com.example.springcloudcustomer.feignservice.HelloFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: chenqibin
 * @Date: 2019/8/26 10:45
 * @Description:
 */
@Component
public class HelloFeignServiceFallbackFactory implements FallbackFactory<HelloFeignService> {
    @Override
    public HelloFeignService create(Throwable throwable) {
        return new HelloFeignService() {
            @Override
            public String hi(String name) {
                return "因相关服务关闭，故调用服务失败！服务降级成功！";
            }
        };
    }
}
