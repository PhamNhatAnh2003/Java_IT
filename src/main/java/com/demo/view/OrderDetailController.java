package com.demo.view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

import com.demo.model.BillDetail;
import com.demo.model.BillDetailDAO;

public class OrderDetailController {
    @FXML
    private TableView<BillDetail> orderDetailTable;
    
	@FXML
	private Button back;
    
	@FXML
	private Button btntaodon;
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
    @FXML
    private TextField quantityField;
    @FXML
    private TextField unitField;
    @FXML
    private TextField deliveryField;
    @FXML
    private TextField midField;

    private ObservableList<BillDetail> orderDetailList;
    private BillDetailDAO billDetailDAO;

    public OrderDetailController() {
        billDetailDAO = new BillDetailDAO();
        orderDetailList = FXCollections.observableArrayList(billDetailDAO.getAllBillDetails());
    }

    @FXML
    private void initialize() {
        bidColumn.setCellValueFactory(new PropertyValueFactory<>("bid"));
        midColumn.setCellValueFactory(new PropertyValueFactory<>("mid"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        deliveryColumn.setCellValueFactory(new PropertyValueFactory<>("delivery"));

        orderDetailTable.setItems(orderDetailList);
    }

    @FXML
    private void addOrderDetail(ActionEvent event) {
        String bid = "B" + (orderDetailList.size() + 1); // Tạo bid giả định
        String mid = midField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        String unit = unitField.getText();
        String delivery = deliveryField.getText();

        BillDetail newBillDetail = new BillDetail(bid, mid, quantity, unit, delivery);
        billDetailDAO.addBillDetail(newBillDetail);
        orderDetailList.add(newBillDetail);
        saveOrderToFile(newBillDetail);
        midField.clear();
        quantityField.clear();
        unitField.clear();
        deliveryField.clear();
    }
    
    private void saveOrderToFile(BillDetail billDetail) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) {
            writer.write(billDetail.toString()); // Đảm bảo phương thức toString() của BillDetail trả về thông tin đúng định dạng
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
