package ru.bnn.ArangoCatProject.Controller;

public class Params {
    private String catKey;
    private String ownerKey;

    public Params(String catKey, String ownerKey) {
        this.catKey = catKey;
        this.ownerKey = ownerKey;
    }

    public String getCatKey() {
        return catKey;
    }

    public void setCatKey(String catKey) {
        this.catKey = catKey;
    }

    public String getOwnerKey() {
        return ownerKey;
    }

    public void setOwnerKey(String ownerKey) {
        this.ownerKey = ownerKey;
    }
}