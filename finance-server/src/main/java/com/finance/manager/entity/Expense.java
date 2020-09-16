package com.finance.manager.entity;


import org.springframework.data.annotation.Id;

public class Expense {
    @Id
    private String id;

    private double amount;

    private Category category;

    public Expense(double amount, Category category, int year, int month, int day, String description) {
        this.amount = amount;
        this.category = category;
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



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
