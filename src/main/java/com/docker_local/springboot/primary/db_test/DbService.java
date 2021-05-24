package com.docker_local.springboot.primary.db_test;

import java.util.List;

import com.docker_local.springboot.primary.db_test.dto.DbContent;

public interface DbService {
    
    public void add(String content);
    public void delete(Long id);
    public void update(Long id, String content);

    public DbContent get(Long id);
    public List<DbContent> getAll();
    

}
