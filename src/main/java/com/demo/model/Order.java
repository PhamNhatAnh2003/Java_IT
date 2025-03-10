package com.demo.model;

public class Order {
    private String bid;
    private String sid;
    private String status;
    private String creatingDate;
    private int productQuantity;

    public Order(String bid, String sid, String status, String creatingDate, int productQuantity) {
        this.bid = bid;
        this.sid = sid;
        this.status = status;
        this.creatingDate = creatingDate;
        this.productQuantity = productQuantity;
    }

    public String getBid() {
        return bid;
    }

    public String getSid() {
        return sid;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatingDate() {
        return creatingDate;
    }

    public int getProductQuantity() {
        return productQuantity;
    }
}
