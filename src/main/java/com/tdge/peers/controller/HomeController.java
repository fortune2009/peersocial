package com.tdge.peers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcome(){
        return "welcome to our website";
    }

}
