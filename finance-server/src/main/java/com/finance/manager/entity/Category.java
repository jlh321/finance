package com.finance.manager.entity;

import org.springframework.data.annotation.Id;

public class Category {

    @Id
    private int id;

    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Category(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
