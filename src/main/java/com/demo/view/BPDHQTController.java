package com.demo.view;

import com.demo.MainMenu;
import com.demo.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BPDHQTController {
    @FXML
    private Button btnHome;
    
    @FXML
    private Button viewOrdersButton;
    
    @FXML
    private Button btnAvailble;
	
    @FXML
    private Button btntaodon;
    
    @FXML
    private Button add;
    
    @FXML
    private TextField sidField;
    @FXML
    private TextField midField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField unitField;
    @FXML
    private TableView<SiteProduct> productTable;
    @FXML
    private TableColumn<SiteProduct, String> sidColumn;
    @FXML
    private TableColumn<SiteProduct, String> midColumn;
    @FXML
    private TableColumn<SiteProduct, Integer> quantityColumn;
    @FXML
    private TableColumn<SiteProduct, String> unitColumn;

    private ObservableList<SiteProduct> productList;

    @FXML
    public void initialize() {
        productList = FXCollections.observableArrayList();
        sidColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));
        midColumn.setCellValueFactory(new PropertyValueFactory<>("mid"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("instockQuantity"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        productTable.setItems(productList);
        loadProducts();
    }

    private void loadProducts() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anhpham", "root", "123456")) {
            String query = "SELECT * FROM site_product";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                productList.add(new SiteProduct(rs.getString("sid"), rs.getString("mid"), rs.getInt("instock_quantity"), rs.getString("unit")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProduct(ActionEvent event) {
        String sid = sidField.getText();
        String mid = midField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        String unit = unitField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anhpham", "root", "123456")) {
            String query = "INSERT INTO site_product (sid, mid, instock_quantity, unit) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, sid);
            pst.setString(2, mid);
            pst.setInt(3, quantity);
            pst.setString(4, unit);
            pst.executeUpdate();
            productList.add(new SiteProduct(sid, mid, quantity, unit));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
    
    public void updateProduct() {
        //  cập nhật sản phẩm
    }

    public void deleteProduct() {
        // để xóa sản phẩm
    }
    
    @FXML
	public void btntaodonpressed(ActionEvent event) {
        try {
            // Load FXML của trang mới
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Orderinformation.fxml"));
            Parent root = loader.load();
            
            // Lấy stage hiện tại từ event
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Thiết lập nội dung mới cho scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	@FXML
	public void btnbuttonpressed(ActionEvent event) {
        try {
            // Load FXML của trang mới
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            Parent root = loader.load();
            
            // Lấy stage hiện tại từ event
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Thiết lập nội dung mới cho scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@FXML
	public void btnorderpressed(ActionEvent event) {
        try {
            // Load FXML của trang mới
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/donhang.fxml"));
            Parent root = loader.load();
            
            // Lấy stage hiện tại từ event
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Thiết lập nội dung mới cho scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@FXML
	public void btnAvailblepressed(ActionEvent event) {
        try {
            // Load FXML của trang mới
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/bpdhqt.fxml"));
            Parent root = loader.load();
            
            // Lấy stage hiện tại từ event
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Thiết lập nội dung mới cho scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

@FXML
private void viewOrders(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vieworder.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}}
