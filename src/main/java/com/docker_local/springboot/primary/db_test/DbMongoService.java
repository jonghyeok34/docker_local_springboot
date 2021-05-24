package com.docker_local.springboot.primary.db_test;

import java.util.List;

import com.docker_local.springboot.primary.db_test.dto.DbMongoContent;

public interface DbMongoService {
    
    public void add(String content);
    public void delete(String id);
    public void update(String id, String content);

    public DbMongoContent get(String id);
    public List<DbMongoContent> getAll();
    

}
