package com.docker_local.springboot.primary.mongo_test.repository;

import com.docker_local.springboot.primary.mongo_test.dao.MongoContentDao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoContentDaoRepository extends MongoRepository<MongoContentDao, String>{
    
}
