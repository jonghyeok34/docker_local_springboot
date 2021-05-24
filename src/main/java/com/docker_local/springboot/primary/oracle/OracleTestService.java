package com.docker_local.springboot.primary.oracle;

import java.util.ArrayList;
import java.util.List;

import com.docker_local.springboot.primary.db_test.DbService;
import com.docker_local.springboot.primary.db_test.dto.DbContent;
import com.docker_local.springboot.primary.oracle.dao.OracleContentDao;
import com.docker_local.springboot.primary.oracle.repository.OracleContentDaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OracleTestService implements DbService{

    @Autowired
    OracleContentDaoRepository repo;

    @Override
    public void add(String content) {
        
        OracleContentDao contentDao = new OracleContentDao();
        contentDao.setContent(content);
        repo.save(contentDao);
        
    }

    @Override
    public void delete(Long id) {
        
        OracleContentDao contentDao = repo.findById(id).get();
        repo.delete(contentDao);
        
    }

    @Override
    public void update(Long id, String content) {
        OracleContentDao contentDao = repo.findById(id).get();
        contentDao.setContent(content);
        repo.save(contentDao);
        
    }

    @Override
    public DbContent get(Long id) {
        OracleContentDao contentDao = repo.findById(id).get();
        return contentDao;
    }

    @Override
    public List<DbContent> getAll() {
        List<DbContent> dbContents =  new ArrayList<DbContent>();
        repo.findAll().iterator().forEachRemaining(dbContents::add);
        return dbContents;
    }

    
}
