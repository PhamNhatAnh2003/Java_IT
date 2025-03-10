package com.demo.model;


public class OrderItem {
    private int id;
    private int orderListId;
    private String itemName;
    private String itemDetails;
    private int quantity;
	

    public OrderItem(int id, String itemName, String itemDetails, int quantity, int orderListId) {
        this.id = id;
        this.orderListId = orderListId;
        this.itemName = itemName;
        this.itemDetails = itemDetails;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getOrderListId() {
        return orderListId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderListId(int orderListId) {
        this.orderListId = orderListId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderListId=" + orderListId +
                ", itemName='" + itemName + '\'' +
                ", itemDetails='" + itemDetails + '\'' +
                ", quantity=" + quantity +
                '}';
    }

	

	
}
