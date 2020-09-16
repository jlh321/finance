package com.finance.manager.entity;

import org.springframework.data.annotation.Id;


public class AccountTransaction {


    @Id
    private String id;
    private double amount;
    private int year;
    private int month;
    private int day;
    private String description;
    private Account account;
    private boolean hasAllocated;


    public AccountTransaction(String id, double amount, int year, int month, int day, String description, Account account, boolean hasAllocated) {
        this.id = id;
        this.amount = amount;
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
        this.account = account;
        this.hasAllocated = hasAllocated;
    }

    public AccountTransaction(double amount, int year, int month, int day, String description, Account account) {
        this.amount = amount;
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public boolean isHasAllocated() {
        return hasAllocated;
    }

    public void setHasAllocated(boolean hasAllocated) {
        this.hasAllocated = hasAllocated;
    }
}
