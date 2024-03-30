package com.sebastian.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping(value = "greeting", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting(){
        return "Hello world!";
    }
}
