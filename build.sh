#!/bin/bash
docker build --build-arg ENVIRONMENT=dev -t test-spring-build:dev .
# 
docker rm -f test-spring
docker run -d -p 30080:8082  --name=test-spring \
--network db_default \
--link demo_oracle:demo_oracle \
--link demo_mysql:demo_mysql \
--link demo_mongodb:demo_mongodb \
test-spring-build:dev
docker logs -f test-spring