package com.docker_local.springboot.primary.mongo_test.dao;

import javax.persistence.Id;

import com.docker_local.springboot.primary.db_test.dto.DbMongoContent;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("test")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MongoContentDao extends DbMongoContent{
    @Id
    private String id;

    @Field("content")
    private String content;
}
