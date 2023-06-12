package com.example.visual_lab3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BMI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        VBox leftBox = new VBox();
        leftBox.setPadding(new Insets(0, 50, 0, 0));
//        leftBox.setPrefWidth(50);
        leftBox.setSpacing(20);
        leftBox.setAlignment(Pos.BASELINE_RIGHT);
        Label lblHeight = new Label("Height: ");
        Label lblWeight = new Label("Weight: ");
        Label lblBMI = new Label("BMI: ");
        leftBox.getChildren().addAll(lblHeight, lblWeight, lblBMI);
        root.setLeft(leftBox);

        VBox centerBox = new VBox();
        centerBox.setSpacing(10);

        HBox heightBox = new HBox(10);
        heightBox.setAlignment(Pos.CENTER_LEFT);
        TextField feetText = new TextField();
        feetText.setPrefWidth(80);
        Label lblFeet = new Label("feet");
        TextField inchesText = new TextField();
        inchesText.setPrefWidth(80);
        Label lblInches = new Label("inches");
        heightBox.getChildren().addAll(feetText, lblFeet, inchesText, lblInches);

        HBox weightBox = new HBox(10);
        weightBox.setAlignment(Pos.CENTER_LEFT);
        TextField weightText = new TextField();
        weightText.setPrefWidth(80);
        Label pounds = new Label("pounds");
        weightBox.getChildren().addAll(weightText, pounds);

        HBox bmiBox = new HBox(10);
        bmiBox.setAlignment(Pos.CENTER_LEFT);
        TextField BMIText = new TextField();
        BMIText.setPrefWidth(150);
        bmiBox.getChildren().addAll(BMIText);

        centerBox.getChildren().addAll(heightBox, weightBox, bmiBox);
        root.setCenter(centerBox);

        HBox btnBox = new HBox(10);
        Button btnBMI = new Button("Compute BMI");
        Button btnClear = new Button("Clear");
        btnClear.setPrefWidth(70);
        Button btnExit = new Button("Exit");
        btnExit.setPrefWidth(70);
        btnBox.getChildren().addAll(btnBMI, btnClear, btnExit);

        root.setBottom(btnBox);

        btnBMI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int height = Integer.parseInt(inchesText.getText());
                height += Integer.parseInt(feetText.getText());
                double weight = Double.parseDouble(weightText.getText());
                double resBMI = weight / Math.pow(height, 2);

                BMIText.setText(String.valueOf(resBMI));
            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                inchesText.clear();
                feetText.clear();
                weightText.clear();
                BMIText.clear();
            }
        });

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BMI Calculator");
        primaryStage.show();
    }
}
