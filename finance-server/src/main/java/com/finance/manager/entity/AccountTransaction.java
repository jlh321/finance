package com.finance.manager.entity;

import org.springframework.data.annotation.Id;


public class AccountTransaction {
    @Id
    private int id;
    private double amount;
    private int year;
    private int month;
    private int day;
    private String description;
    private int accountId;

    public AccountTransaction(int id, double amount, int year, int month, int day, String description, int accountId) {
        this.id = id;
        this.amount = amount;
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
        this.accountId = accountId;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
