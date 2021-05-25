package com.docker_local.springboot.primary.oracle;

import java.util.ArrayList;
import java.util.List;

import com.docker_local.springboot.primary.oracle.dao.OracleContentDao;
import com.docker_local.springboot.primary.oracle.repository.OracleContentDaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OracleTestService{

    @Autowired
    OracleContentDaoRepository repo;

    public void add(String content) {
        
        OracleContentDao contentDao = new OracleContentDao();
        contentDao.setContent(content);
        repo.save(contentDao);
        
    }

    public void delete(Long id) {
        
        OracleContentDao contentDao = repo.findById(id).get();
        repo.delete(contentDao);
        
    }

    public void update(Long id, String content) {
        OracleContentDao contentDao = repo.findById(id).get();
        contentDao.setContent(content);
        repo.save(contentDao);
        
    }

    public OracleContentDao get(Long id) {
        OracleContentDao contentDao = repo.findById(id).get();
        return contentDao;
    }

    public List<OracleContentDao> getAll() {
        List<OracleContentDao> dbContents =  new ArrayList<OracleContentDao>();
        repo.findAll().iterator().forEachRemaining(dbContents::add);
        return dbContents;
    }

    
}
