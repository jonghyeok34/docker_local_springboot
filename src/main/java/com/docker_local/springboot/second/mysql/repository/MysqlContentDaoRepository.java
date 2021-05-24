package com.docker_local.springboot.second.mysql.repository;

import com.docker_local.springboot.second.mysql.dao.MySqlContentDao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlContentDaoRepository extends CrudRepository<MySqlContentDao, Long> {
    
}
