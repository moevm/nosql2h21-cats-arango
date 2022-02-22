package ru.bnn.ArangoCatProject.Model;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import org.springframework.data.annotation.Id;

@Document("Cats")
public class Cats {

    @Id
    private String key;

    private String name;
    private Integer weight;
    private Integer age;
    private String description;
    private String appearance_date;

    @Relations(edges = HaveBreed.class, lazy = true)
    private HaveBreed breed;

    @Relations(edges = HaveOwner.class, lazy = true)
    private HaveOwner owner;

    public Cats(){

    }

    public String getKey() {
        return key;
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

    public HaveBreed getBreed() {
        return breed;
    }

    public void setBreed(HaveBreed breed) {
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
