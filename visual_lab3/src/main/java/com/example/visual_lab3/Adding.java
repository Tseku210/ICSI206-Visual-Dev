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
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Adding extends Application {

    Button btnAdd, btnClear, btnExit;
    TextField firstNumber, secondNumber, result;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        HBox centerBox = new HBox();
        centerBox.setSpacing(10);
        centerBox.setAlignment(Pos.CENTER);

        VBox leftBox = new VBox();
        leftBox.setSpacing(20);
        leftBox.setAlignment(Pos.BASELINE_RIGHT);
        Label firstLabel = new Label("First Number: ");
        Label secondLabel = new Label("Second Number: ");
        Label resultLabel = new Label("Result: ");
        leftBox.getChildren().addAll(firstLabel, secondLabel, resultLabel);

        VBox rightBox = new VBox();
        rightBox.setSpacing(10);
        int textWidth = 25;
        firstNumber = new TextField();
        firstNumber.setPrefColumnCount(textWidth);
        secondNumber = new TextField();
        secondNumber.setPrefColumnCount(textWidth);
        result = new TextField();
        result.setPrefColumnCount(textWidth);

        HBox btnBox = new HBox(10);
        BorderPane.setMargin(btnBox, new Insets(30, 10, 30, 10));
        btnAdd = new Button("Add");
        btnAdd.setPrefWidth(80);
        btnClear = new Button("Clear");
        btnClear.setPrefWidth(80);
        btnBox.getChildren().addAll(btnAdd, btnClear);

        rightBox.getChildren().addAll(firstNumber, secondNumber, result, btnBox);

        centerBox.getChildren().addAll(leftBox, rightBox);

        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-border-color: blue;");
        stackPane.setPadding(new Insets(10));
        stackPane.getChildren().addAll(centerBox);

        root.setCenter(stackPane);

//        root.setCenter(stackPane);

        btnExit = new Button("Exit");
        btnExit.setPrefWidth(80);
        BorderPane.setMargin(btnExit, new Insets(0, 10, 0, 0));

        BorderPane.setAlignment(btnExit, Pos.BOTTOM_RIGHT);
        root.setBottom(btnExit);

//        stackPane.getChildren().addAll(centerBox);

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (firstNumber.getText().matches("\\d+") && secondNumber.getText().matches("\\d+")) {
                    double firstNum = Double.parseDouble(firstNumber.getText());
                    double secondNum = Double.parseDouble(secondNumber.getText());
                    double res = firstNum + secondNum;
                    result.setText(String.valueOf(res));
                } else {
                    result.setText("Orolt buruu");
                }
            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                firstNumber.clear();
                secondNumber.clear();
                result.clear();
            }
        });

        Scene scene = new Scene(root, 460, 320);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Number Addition");
        primaryStage.show();
    }
}
