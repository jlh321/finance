package com.finance.manager.entity;

import org.springframework.data.annotation.Id;

public class Account {
    @Id
    private int id;

    private String name;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(){}

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
