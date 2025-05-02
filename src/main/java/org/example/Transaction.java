package org.example;

import java.time.LocalDateTime;

public class Transaction {

    private LocalDateTime dateTime;
    private String description;
    private  String vendor;
    private double amount;

    public Transaction(String description, String vendor, double amount) {
        this.dateTime = LocalDateTime.now();
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public Transaction() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-30s %-25s %-10s",
                getDateTime(),
                getDescription(),
                getVendor(),
                getAmount());
    }

}
