package com.springsamples.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by edara on 4/3/17.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HelloServerApp {
    public static void main(String[] args) {
        SpringApplication.run(HelloServerApp.class,args);
    }
}
