package com.self.pickup.provider.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello !";
    }
}
