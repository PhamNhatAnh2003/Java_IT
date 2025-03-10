package com.demo.model;

public class BillDetail {
    private String bid;
    private String mid;
    private int quantity;
    private String unit;
    private String delivery;

    public BillDetail(String bid, String mid, int quantity, String unit, String delivery) {
        this.bid = bid;
        this.mid = mid;
        this.quantity = quantity;
        this.unit = unit;
        this.delivery = delivery;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
}
