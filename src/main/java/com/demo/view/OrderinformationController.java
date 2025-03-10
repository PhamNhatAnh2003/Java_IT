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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.demo.model.BillDetail;
import com.demo.model.BillDetailDAO;
import java.io.IOException;
import java.time.LocalDate;

public class OrderinformationController {

	@FXML
	private Button btnback;
	
    @FXML
    private Label status;

    @FXML
    private TableView<BillDetail> tableView;

    @FXML
    private TableColumn<BillDetail, String> merchandiseID;

    @FXML
    private TableColumn<BillDetail, String> merchandiseName;

    @FXML
    private TableColumn<BillDetail, Integer> quantity;

    @FXML
    private TableColumn<BillDetail, String> unit;

    @FXML
    private TableColumn<BillDetail, String> delivery;

    @FXML
    private Button acceptButton;

    @FXML
    private Button rejectButton;

    @FXML
    private Label siteName;

    @FXML
    private Label creatingDate;

    @FXML
    private Label productQuantity;

    @FXML
    private TextField customerNameField;

    private ObservableList<BillDetail> orderDetailList;
    private BillDetailDAO billDetailDAO;

    public OrderinformationController() {
        billDetailDAO = new BillDetailDAO();
        orderDetailList = FXCollections.observableArrayList(billDetailDAO.getAllBillDetails());
    }

    @FXML
    private void initialize() {
        merchandiseID.setCellValueFactory(new PropertyValueFactory<>("bid"));
        merchandiseName.setCellValueFactory(new PropertyValueFactory<>("mid")); // Assuming merchandise name is stored in mid
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        delivery.setCellValueFactory(new PropertyValueFactory<>("delivery"));

        tableView.setItems(orderDetailList);

        // Placeholder values for demonstration
        creatingDate.setText(LocalDate.now().toString());
        productQuantity.setText(String.valueOf(orderDetailList.size()));
        status.setText("Pending");
    }

    @FXML
    private void btnaccept(ActionEvent event) {
        // Set the customer name from the text field to the label
        siteName.setText(customerNameField.getText());
        status.setText("Order Created");
    }

    @FXML
    private void btnject(ActionEvent event) {
        // Logic for rejecting an order
        status.setText("Order Canceled");
    }



@FXML
public void back(ActionEvent event) {
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
}}

