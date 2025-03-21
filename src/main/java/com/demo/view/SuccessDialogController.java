package com.demo.view;

import java.io.IOException;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SuccessDialogController {
    @FXML
    private Button btnreturn;

    public void btnreturnpressed(ActionEvent event)  {
    	
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
