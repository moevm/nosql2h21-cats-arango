package ru.bnn.ArangoCatProject.Model;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import com.arangodb.springframework.annotation.Rev;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

@Document("Cats")
public class Cats {

    @ArangoId
    private String _id;
    @Id
    private String _key;
    @Rev
    private String _rev;

    private String name;
    private Integer weight;
    private Integer age;
    private String about;
    private String arrival_date;

    @Relations(edges = HaveBreed.class, lazy = true)
    private HaveBreed breed;

    public HaveBreed getBreed() {
        return breed;
    }

    public HaveOwner getOwner() {
        return owner;
    }

    @Relations(edges = HaveOwner.class, lazy = true)
    private HaveOwner owner;

    public Cats(){

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public void setBreed(HaveBreed breed) {
        this.breed = breed;
    }

    public void setOwner(HaveOwner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Cats{" +
                "_id:'" + _id + '\'' +
                ", key:'" + _key + '\'' +
                ",_rev:'" + _rev + '\'' +
                ", name:'" + name + '\'' +
                ", weight=" + weight +
                ", age:'" + age +
                ", description:'" + about + '\'' +
                ", appearance_date:'" + arrival_date + '\'' +
                (owner != null ? "owner:'" + owner.get_to().getFirst_name() + ' ' + owner.get_to().getSurname() + '\'' +
                "document:'" + owner.get_to().getPassport() + '}' : "}");
    }
}
