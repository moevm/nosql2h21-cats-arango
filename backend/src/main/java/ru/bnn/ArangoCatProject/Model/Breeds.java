package ru.bnn.ArangoCatProject.Model;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Rev;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

@Document("Breeds")
public class Breeds {
    @ArangoId
    private String _id;
    @Id
    private String _key;

    @Rev
    private String _rev;

    private String name;
    private String about;

    public Breeds(){

    }

    public String get_id() {
        return _id;
    }

    public String get_key() {
        return _key;
    }

    public String get_rev() {
        return _rev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Breeds{" +
                "_id='" + _id + '\'' +
                ", _key='" + _key + '\'' +
                ", _rev='" + _rev + '\'' +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
