package com.demo.view;

import com.demo.model.BillDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BillDetailController {
	
	@FXML
	private Button back;
	
    @FXML
    private TextField bidField;
    @FXML
    private TextField midField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField unitField;
    @FXML
    private TextField deliveryField;
    @FXML
    private TableView<BillDetail> billDetailTable;
    @FXML
    private TableColumn<BillDetail, String> bidColumn;
    @FXML
    private TableColumn<BillDetail, String> midColumn;
    @FXML
    private TableColumn<BillDetail, Integer> quantityColumn;
    @FXML
    private TableColumn<BillDetail, String> unitColumn;
    @FXML
    private TableColumn<BillDetail, String> deliveryColumn;

    private ObservableList<BillDetail> billDetailList;

    @FXML
    public void initialize() {
        billDetailList = FXCollections.observableArrayList();
        bidColumn.setCellValueFactory(new PropertyValueFactory<>("bid"));
        midColumn.setCellValueFactory(new PropertyValueFactory<>("mid"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        deliveryColumn.setCellValueFactory(new PropertyValueFactory<>("delivery"));
        billDetailTable.setItems(billDetailList);
        loadBillDetails();
    }

    private void loadBillDetails() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anhpham", "root", "123456")) {
            String query = "SELECT * FROM bill_detail";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                billDetailList.add(new BillDetail(rs.getString("bid"), rs.getString("mid"), rs.getInt("quantity"), rs.getString("unit"), rs.getString("delivery")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBillDetail() {
        String bid = bidField.getText();
        String mid = midField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        String unit = unitField.getText();
        String delivery = deliveryField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anhpham", "root", "123456")) {
            String query = "INSERT INTO bill_detail (bid, mid, quantity, unit, delivery) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, bid);
            pst.setString(2, mid);
            pst.setInt(3, quantity);
            pst.setString(4, unit);
            pst.setString(5, delivery);
            pst.executeUpdate();
            billDetailList.add(new BillDetail(bid, mid, quantity, unit, delivery));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBillDetail() {
        // Logic để cập nhật chi tiết hóa đơn
    }

    public void deleteBillDetail() {
        // Logic để xóa chi tiết hóa đơn
    }





@FXML
public void returnto(ActionEvent event) {
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
}