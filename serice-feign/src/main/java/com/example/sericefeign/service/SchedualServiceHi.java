package com.example.sericefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// 定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务
@FeignClient(value = "service-hi")
public interface SchedualServiceHi {

    // 在代码中调用了service-hi服务的“/hi”接口
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}