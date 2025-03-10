package com.demo.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainMenuController {

   @FXML
   private Button DHbutton;
	
    public void btnbuttonpressed(ActionEvent event) {
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
