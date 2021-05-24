package com.docker_local.springboot.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestMainController {
    
    @RequestMapping("/add")
    public String add(@RequestBody Map<String, String> map){
        String text = map.get("text");

        return "success";
    } 
    
}
