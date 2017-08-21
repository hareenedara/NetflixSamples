package com.samples.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by edara on 4/6/17.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignClientApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignClientApp.class,args);
    }
}
