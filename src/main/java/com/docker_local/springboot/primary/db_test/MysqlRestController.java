package com.docker_local.springboot.primary.db_test;

import java.util.List;
import java.util.Map;

import com.docker_local.springboot.second.mysql.MySqlTestService;
import com.docker_local.springboot.second.mysql.dao.MySqlContentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/mysql")
public class MysqlRestController {
    
    @Autowired
    private MySqlTestService service;
    
    @GetMapping("/all")
    public List<MySqlContentDao> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Map<String, String> map){
    
        service.add(map.get("content"));
        return "success";
    }
    
    @PostMapping("/update")
    public String update( @RequestBody Map<String, String> map){
    
        service.update(Long.parseLong(map.get("id")), map.get("content"));
        return "success";
    }

    @PostMapping("/delete")
    public String delete( @RequestBody Map<String, String> map){
    
        service.delete(Long.parseLong(map.get("id")));
        return "success";
    }
    
}
