package com.docker_local.springboot.primary.db_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class DbMongoContent {
    private String id;
    private String content;
}
