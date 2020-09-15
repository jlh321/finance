package com.finance.manager.entity;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;

public class Expense {
    @Id
    private String id;

    private double amount;

    private int catId;

    public Expense(double amount, int catId, int year, int month, int day, String description) {
//        this.id = id;
        this.amount = amount;
        this.catId = catId;
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
    }

    public Expense(){

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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int year;

    private int month;

    private int day;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
