package com.docker_local.springboot.primary.oracle.repository;

import com.docker_local.springboot.primary.oracle.dao.OracleContentDao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleContentDaoRepository extends CrudRepository<OracleContentDao, Long> {
    
}
