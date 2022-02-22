package ru.bnn.ArangoCatProject.Model;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Rev;
import org.springframework.data.annotation.Id;

@Document("Owners")
public class Owners {
    @ArangoId
    private String _id;
    @Id
    private String _key;
    @Rev
    private String _rev;

    private String surname;
    private String first_name;
    private String passport;
    private String birth_date;

    public Owners(){

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
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
                "_id='" + _id + '\'' +
                ", key='" + _key + '\'' +
                ", _rev='" + _rev + '\'' +
                ", full_name='" + surname + first_name + '\'' +
                ", passport='" + passport + '\'' +
                ", birth_date='" + birth_date + '\'' +
                '}';
    }
}
