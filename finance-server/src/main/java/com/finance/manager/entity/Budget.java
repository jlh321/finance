package com.finance.manager.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Budget implements Serializable {
    @Id
    private int id;

    private double amount;

    private int catId;

    private int year;

    private int month;

    public Budget(int id, double amount, int catId, int year, int month) {
        this.id = id;
        this.amount = amount;
        this.catId = catId;
        this.year = year;
        this.month = month;
    }

    public Budget(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

}