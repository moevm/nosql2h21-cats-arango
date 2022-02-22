package ru.bnn.ArangoCatProject.Model;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import org.springframework.data.annotation.Id;

@Edge
public class HaveOwner {
    @Id
    private String _key;

    @From
    private Cats _from;
    @To
    private Owners _to;

    public HaveOwner() {

    }

    public String get_key() {
        return _key;
    }

    public Cats get_from() {
        return _from;
    }

    public void set_from(Cats _from) {
        this._from = _from;
    }

    public Owners get_to() {
        return _to;
    }

    public void set_to(Owners _to) {
        this._to = _to;
    }

    @Override
    public String toString() {
        return "HaveOwner{" +
                "_key='" + _key + '\'' +
                ", _from=" + _from +
                ", _to=" + _to +
                '}';
    }
}
