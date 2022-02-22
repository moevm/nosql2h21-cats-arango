package ru.bnn.ArangoCatProject.Model;

import com.arangodb.springframework.annotation.*;
import org.springframework.data.annotation.Id;

@Edge
public class HaveOwner {
    @ArangoId
    private String _id;
    @Id
    private String _key;
    @Rev
    private String _rev;

    @From
    private Cats _from;
    @To
    private Owners _to;

    public HaveOwner(){

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

    public void set_from(Cats _from) {
        this._from = _from;
    }

    public void set_to(Owners _to) {
        this._to = _to;
    }

    public Cats get_from() {
        return _from;
    }

    public Owners get_to() {
        return _to;
    }

    @Override
    public String toString() {
        return "HaveOwner{" +
                "_id='" + _id + '\'' +
                ", _key='" + _key + '\'' +
                ", _rev='" + _rev + '\'' +
                ", _from=" + _from +
                ", _to=" + _to +
                '}';
    }
}
