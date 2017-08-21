package com.samples.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by edara on 4/6/17.
 */
@FeignClient("hello-service")
public interface HelloClient {
    @RequestMapping(value = "/helloservice/{n}",method = RequestMethod.GET)
    public String sayHello(@PathVariable("n") String n);
}
