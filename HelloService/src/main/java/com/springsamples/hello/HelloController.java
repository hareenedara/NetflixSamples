package com.springsamples.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/helloservice",produces="application/json")
public class HelloController {
    @GetMapping("/{name}")
    public String get(@PathVariable String name){
        return "Hello "+name;
    }

}
