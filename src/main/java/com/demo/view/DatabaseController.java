package com.demo.view;



import com.demo.model.DatabaseConfig;
import com.demo.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseController {

    @FXML
    private TableView<Order> orderTable;

    @FXML
    private TableColumn<Order, String> bidColumn;

    @FXML
    private TableColumn<Order, String> sidColumn;

    @FXML
    private TableColumn<Order, String> statusColumn;

    @FXML
    private TableColumn<Order, String> creatingDateColumn;

    @FXML
    private TableColumn<Order, Integer> productQuantityColumn;

    private ObservableList<Order> orderList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configure the table columns
        bidColumn.setCellValueFactory(new PropertyValueFactory<>("bid"));
        sidColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        creatingDateColumn.setCellValueFactory(new PropertyValueFactory<>("creatingDate"));
        productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));

        // Load data from the database
        loadOrderData();

        // Set data to the table
        orderTable.setItems(orderList);
    }

    private void loadOrderData() {
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bill")) {

            while (rs.next()) {
                String bid = rs.getString("bid");
                String sid = rs.getString("sid");
                String status = rs.getString("status");
                String creatingDate = rs.getString("creating_date");
                int productQuantity = rs.getInt("product_quantity");

                Order order = new Order(bid, sid, status, creatingDate, productQuantity);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
