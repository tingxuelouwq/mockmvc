package com.kevin.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -6516708617944106348L;

    private String id;
    private String name;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
