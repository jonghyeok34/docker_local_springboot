package com.docker_local.springboot.primary.mongo_test;

import java.util.ArrayList;
import java.util.List;

import com.docker_local.springboot.primary.mongo_test.dao.MongoContentDao;
import com.docker_local.springboot.primary.mongo_test.repository.MongoContentDaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoTestService{

    @Autowired
    private MongoContentDaoRepository repo;

    
    public void add(String content) {
        MongoContentDao contentDao = new MongoContentDao();
        contentDao.setContent(content);
        repo.save(contentDao);
        
    }

    
    public void delete(String id) {
        MongoContentDao contentDao = repo.findById(id).get();
        repo.delete(contentDao);
        
    }

    
    public void update(String id, String content) {
        MongoContentDao contentDao = repo.findById(id).get();
        contentDao.setContent(content);
        repo.save(contentDao);
        
    }

    
    public MongoContentDao get(String id) {
        MongoContentDao contentDao =repo.findById(id).get();
        return contentDao;
    }

    
    public List<MongoContentDao> getAll() {
        List<MongoContentDao> dbContents =  new ArrayList<MongoContentDao>();
        repo.findAll().iterator().forEachRemaining(dbContents::add);
        return dbContents;
    }

}
