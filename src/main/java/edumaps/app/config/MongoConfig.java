package edumaps.app.config;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"edumaps.app.repository"})
public class MongoConfig {

    @Value("${mongo.host}")
    private String host;
    @Value("${mongo.port}")
    private Integer port;
    @Value("${mongo.db}")
    private String database;

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoCredential mongoCredential =
                MongoCredential.createScramSha1Credential("odm", "admin", "toor".toCharArray()); //todo  hide
        MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), Lists.newArrayList(mongoCredential));
        MongoDbFactory dbFactory = new SimpleMongoDbFactory(mongoClient, database);
        MappingMongoConverter converter =
                new MappingMongoConverter(dbFactory, new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        converter.afterPropertiesSet();
        return new MongoTemplate(dbFactory, converter);
    }
}
