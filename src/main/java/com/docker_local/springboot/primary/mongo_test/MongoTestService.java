package com.docker_local.springboot.primary.mongo_test;

import java.util.ArrayList;
import java.util.List;

import com.docker_local.springboot.primary.db_test.DbMongoService;
import com.docker_local.springboot.primary.db_test.dto.DbMongoContent;
import com.docker_local.springboot.primary.mongo_test.dao.MongoContentDao;
import com.docker_local.springboot.primary.mongo_test.repository.MongoContentDaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoTestService implements DbMongoService{

    @Autowired
    private MongoContentDaoRepository repo;

    @Override
    public void add(String content) {
        MongoContentDao contentDao = new MongoContentDao();
        contentDao.setContent(content);
        repo.save(contentDao);
        
    }

    @Override
    public void delete(String id) {
        MongoContentDao contentDao = repo.findById(id).get();
        repo.delete(contentDao);
        
    }

    @Override
    public void update(String id, String content) {
        MongoContentDao contentDao = repo.findById(id).get();
        contentDao.setContent(content);
        repo.save(contentDao);
        
    }

    @Override
    public DbMongoContent get(String id) {
        MongoContentDao contentDao =repo.findById(id).get();
        return contentDao;
    }

    @Override
    public List<DbMongoContent> getAll() {
        List<DbMongoContent> dbContents =  new ArrayList<DbMongoContent>();
        repo.findAll().iterator().forEachRemaining(dbContents::add);
        return dbContents;
    }

}
