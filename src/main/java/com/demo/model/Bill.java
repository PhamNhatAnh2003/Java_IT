package com.demo.model;


import java.time.LocalDate;

public class Bill {
    private String status;
    private String bid;
    private String sid;
    private LocalDate creationDate;
    private int productQuantity;

    public Bill(String status, String bid, String sid, LocalDate creationDate, int productQuantity) {
        this.status = status;
        this.bid = bid;
        this.sid = sid;
        this.creationDate = creationDate;
        this.productQuantity = productQuantity;
    }

    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return bid;
    }

    public void setId(String id) {
        this.bid = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "status='" + status + '\'' +
                ", id='" + bid + '\'' +
                ", creationDate=" + creationDate +
                ", productQuantity=" + productQuantity +
                '}';
    }
}