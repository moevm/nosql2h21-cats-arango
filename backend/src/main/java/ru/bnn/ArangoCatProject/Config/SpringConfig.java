package ru.bnn.ArangoCatProject.Config;

import com.arangodb.ArangoDB;
import com.arangodb.Protocol;
import com.arangodb.entity.CollectionType;
import com.arangodb.model.CollectionCreateOptions;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableArangoRepositories(basePackages = {"ru.bnn"})
public class SpringConfig implements ArangoConfiguration {

    @Override
    public ArangoDB.Builder arango() {

        ArangoDB.Builder arango = new ArangoDB.Builder()
                .host("db", 8529)
                .useProtocol(Protocol.HTTP_JSON)
                .user("root")
                .password("123");

        ArangoDB db = arango.build();

        if (!db.db("ArangoCats").exists()) {
            db.createDatabase("ArangoCats");
            db.db("ArangoCats").createCollection("Cats");
            //fill cats
            db.db("ArangoCats").createCollection("Owners");
            //fill owners
            db.db("ArangoCats").createCollection("HaveOwner", new CollectionCreateOptions().type(CollectionType.EDGES));
            //fill edges
        }

        return arango;
    }

    @Override
    public String database() {
        return "ArangoCats";
    }
}
