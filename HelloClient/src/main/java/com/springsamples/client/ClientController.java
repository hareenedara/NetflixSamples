package com.springsamples.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by edara on 4/3/17.
 */
@RestController
@RequestMapping(value="/client",produces="application/json")
public class ClientController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/eureka/{name}")
    public String get(@PathVariable String name) {
        ResponseEntity<String> response = restTemplate.getForEntity("//hello-service/helloservice/{id}",String.class,name );
        return response.getBody();
    }

    @GetMapping("/non-eureka/{name}")
    public String get2(@PathVariable String name){
        List<ServiceInstance> instances = discoveryClient.getInstances("HELLO-SERVICE");
        String url = instances.get(0).getUri().toString();
        RestTemplate restTemplate2 = new RestTemplate();
        ResponseEntity<String> response = restTemplate2.getForEntity(url+"/helloservice/{id}",String.class,name);
        return response.getBody();

    }
    @GetMapping("/zuulproxy/{name}")
    public String get3(@PathVariable String name){
        System.out.println("Using Zuul proxy");
        ResponseEntity<String> response = restTemplate.getForEntity("http://zuul-proxy/helloservice/{name}",String.class,name);
        return response.getBody();
    }


}
