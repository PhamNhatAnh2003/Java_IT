package com.demo.model;

public class SiteProduct {
    private String sid;
    private String mid;
    private int instockQuantity;
    private String unit;

    // Constructor, getters và setters
    public SiteProduct(String sid, String mid, int instockQuantity, String unit) {
        this.sid = sid;
        this.mid = mid;
        this.instockQuantity = instockQuantity;
        this.unit = unit;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public int getInstockQuantity() {
        return instockQuantity;
    }

    public void setInstockQuantity(int instockQuantity) {
        this.instockQuantity = instockQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
