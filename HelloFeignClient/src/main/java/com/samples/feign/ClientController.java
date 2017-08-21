package com.samples.feign;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by edara on 4/6/17.
 */
@RestController
@RequestMapping(value="/feign")
public class ClientController {
    @Autowired
    HelloClient helloClient;

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String get(@PathVariable("name") String name){
        return helloClient.sayHello(name);
    }
}
