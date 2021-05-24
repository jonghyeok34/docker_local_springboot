package com.docker_local.springboot.primary.oracle.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.docker_local.springboot.primary.db_test.dto.DbContent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TEST_CONTENT", schema = "DEMO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OracleContentDao extends DbContent{
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "DEMO_TEST_SEQ_NO_")
    @Column(name = "TEST_SEQ_NO")
    @SequenceGenerator(sequenceName="DEMO_TEST_SEQ_NO", schema="DEMO_TEST_SEQ_NO", name="DEMO_TEST_SEQ_NO_")
    private Long id;

    @Column(name = "CONTENT")
    private String content;

}
