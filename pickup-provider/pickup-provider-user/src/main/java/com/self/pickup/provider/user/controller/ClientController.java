package com.self.pickup.provider.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @RequestMapping("/login")
    public String login(){
        return "Hello !";
    }
}
