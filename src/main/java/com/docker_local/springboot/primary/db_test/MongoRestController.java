package com.docker_local.springboot.primary.db_test;

import java.util.List;
import java.util.Map;

import com.docker_local.springboot.primary.mongo_test.MongoTestService;
import com.docker_local.springboot.primary.mongo_test.dao.MongoContentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/mongo")
public class MongoRestController {
    
    @Autowired
    private MongoTestService service;

    @GetMapping("/all")
    public List<MongoContentDao> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestHeader Map<String, String> header, @RequestBody Map<String, String> map){
    
        service.add(map.get("content"));
        return "success";
    }

    @PostMapping("/update")
    public String update( @RequestBody Map<String, String> map){
    
        service.update(map.get("id"), map.get("content"));
        return "success";
    }
}
