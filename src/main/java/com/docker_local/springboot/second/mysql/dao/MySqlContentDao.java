package com.docker_local.springboot.second.mysql.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.docker_local.springboot.primary.db_test.dto.DbContent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TEST", schema = "DEMO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MySqlContentDao extends DbContent {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "TEST_SEQ_NO")
    private Long id;

    @Column(name = "CONTENT")
    private String content;

}
