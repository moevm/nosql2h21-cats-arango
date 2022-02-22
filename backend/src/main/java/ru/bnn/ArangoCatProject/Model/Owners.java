package ru.bnn.ArangoCatProject.Model;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Rev;
import org.springframework.data.annotation.Id;

@Document("Owners")
public class Owners {
    @Id
    private String key;

    private String full_name;
    private String document;
    private String birth_date;

    public Owners(){

    }

    public String getKey() {
        return key;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "Owners{" +
                "key:'" + key + '\'' +
                ", full_name:'" + full_name + '\'' +
                ", document:'" + document + '\'' +
                ", birth_date:'" + birth_date + '\'' +
                '}';
    }
}