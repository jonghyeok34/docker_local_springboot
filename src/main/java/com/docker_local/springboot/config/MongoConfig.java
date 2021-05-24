package com.docker_local.springboot.config;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MongoConfig {

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private char[] password;

    @Autowired
    private MongoMappingContext mongoMappingContext;

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoDatabaseFactory mongoDatabaseFactory = new SimpleMongoClientDatabaseFactory(loggingClient(), database);
        return new MongoTemplate(mongoDatabaseFactory, mappingMongoConverter());
    }

    @WritingConverter
    enum ZonedDateTimeToDateConverter implements Converter<ZonedDateTime, LocalDateTime> {
        INSTANCE;

        public LocalDateTime convert(ZonedDateTime source) {
            return source == null ? null : LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
        }
    }

    // @Bean

    // @Bean
    @Bean
    public MongoClient loggingClient() {

        MongoCredential credential = MongoCredential.createCredential(username, database, password);

        return MongoClients.create(MongoClientSettings.builder().credential(credential).applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(host, port)))).build());
    }

    // converter - remove _class
    public MappingMongoConverter mappingMongoConverter() {
        MongoDatabaseFactory mongoDatabaseFactory = new SimpleMongoClientDatabaseFactory(loggingClient(), database);
        DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDatabaseFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        converter.afterPropertiesSet();
        return converter;
    }

}
