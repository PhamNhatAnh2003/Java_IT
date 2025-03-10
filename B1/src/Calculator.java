package calculator_javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField number1 = new TextField();
    private TextField number2 = new TextField();
    private TextField result = new TextField();
    private Button calculate = new Button("Calculate");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane=new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(new Label("number 1: "), 0, 0);
        gridPane.add(number1, 1, 0);
        gridPane.add(new Label("number 2: "), 0, 1);
        gridPane.add(number2, 1, 1);
        gridPane.add(new Label("result: "), 0, 2);
        gridPane.add(result, 1, 2);
        gridPane.add(calculate, 1, 3);

        gridPane.setAlignment(Pos.CENTER);
        result.setEditable(false);
    
        calculate.setOnAction(event -> {
            // Kiểm tra xem number1 và number2 có phải là số nguyên hay không
            if (isInteger(number1.getText()) && isInteger(number2.getText())) {
                // Chuyển đổi chuỗi sang số nguyên
                int d1 = Integer.parseInt(number1.getText());
                int d2 = Integer.parseInt(number2.getText());
                // Tính tổng và hiển thị kết quả
                int ans = d1 + d2;
                result.setText(String.valueOf(ans));
            } else {
                // Hiển thị cửa sổ thông báo lỗi
                showAlert("Error", "Please enter an integer into 'number 1' and 'number 2'!");
            }
        });

        Scene scene = new Scene(gridPane, 250, 200);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Phương thức kiểm tra xem chuỗi có phải là số nguyên hay không
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Phương thức hiển thị cửa sổ thông báo lỗi
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
