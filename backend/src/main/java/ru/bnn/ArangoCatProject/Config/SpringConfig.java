package ru.bnn.ArangoCatProject.Config;

import com.arangodb.ArangoDB;
import com.arangodb.Protocol;
import com.arangodb.mapping.ArangoJack;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableArangoRepositories(basePackages = {"ru.bnn"})
public class SpringConfig implements ArangoConfiguration {

    @Override
    public ArangoDB.Builder arango() {
        return new ArangoDB.Builder()
                .host("localhost", 8529)
                .useProtocol(Protocol.HTTP_JSON)
                .user("root")
                .password("151199");
    }

    @Override
    public String database() {
        return "ArangoCats";
    }
}