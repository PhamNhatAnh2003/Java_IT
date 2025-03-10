package com.demo.model;

import javafx.beans.property.IntegerProperty;
	import javafx.beans.property.ObjectProperty;
	import javafx.beans.property.SimpleIntegerProperty;
	import javafx.beans.property.SimpleObjectProperty;
	import javafx.beans.property.SimpleStringProperty;
	import javafx.beans.property.StringProperty;

	import java.time.LocalDate;

	public class OrderList {
	    private final IntegerProperty id = new SimpleIntegerProperty();
	    private final StringProperty listName = new SimpleStringProperty();
	    private final IntegerProperty itemCount = new SimpleIntegerProperty();
	    private final ObjectProperty<LocalDate> receiveDate = new SimpleObjectProperty<>();

	    public OrderList(int id, String listName, int itemCount, LocalDate receiveDate) {
	        setId(id);
	        setListName(listName);
	        setItemCount(itemCount);
	        setReceiveDate(receiveDate);
	    }

	    public int getId() {
	        return id.get();
	    }

	    public IntegerProperty idProperty() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id.set(id);
	    }

	    public String getListName() {
	        return listName.get();
	    }

	    public StringProperty listNameProperty() {
	        return listName;
	    }

	    public void setListName(String listName) {
	        this.listName.set(listName);
	    }

	    public int getItemCount() {
	        return itemCount.get();
	    }

	    public IntegerProperty itemCountProperty() {
	        return itemCount;
	    }

	    public void setItemCount(int itemCount) {
	        this.itemCount.set(itemCount);
	    }

	    public LocalDate getReceiveDate() {
	        return receiveDate.get();
	    }

	    public ObjectProperty<LocalDate> receiveDateProperty() {
	        return receiveDate;
	    }

	    public void setReceiveDate(LocalDate receiveDate) {
	        this.receiveDate.set(receiveDate);
	    }

	    @Override
	    public String toString() {
	        return "OrderList{" +
	                "id=" + id.get() +
	                ", listName='" + listName.get() + '\'' +
	                ", itemCount=" + itemCount.get() +
	                ", receiveDate=" + receiveDate.get() +
	                '}';
	    }
	}
