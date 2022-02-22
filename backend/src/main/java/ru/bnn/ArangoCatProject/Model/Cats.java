package ru.bnn.ArangoCatProject.Model;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

@Document("Cats")
public class Cats {

    @Id
    private String key;

    private String name;
    private String weight;
    private String age;
    private String description;
    private String appearance_date;
    private String breed;

    @Relations(edges = HaveOwner.class, lazy = true)
    @JsonIgnore
    private HaveOwner owner = null;

    public Cats() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppearance_date() {
        return appearance_date;
    }

    public void setAppearance_date(String appearance_date) {
        this.appearance_date = appearance_date;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public HaveOwner getOwner() {
        return owner;
    }

    public void setOwner(HaveOwner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Cats{" +
                "key:'" + key + '\'' +
                ", name:'" + name + '\'' +
                ", weight:" + weight +
                ", age:" + age +
                ", description:'" + description + '\'' +
                ", appearance_date:'" + appearance_date + '\'' +
                ", breed:" + breed +
                ", owner:" + owner +
                '}';
    }
}
