package com.example.lab1_visual;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ex extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setSpacing(10);

        // title
        HBox box1 = new HBox();
        box1.setAlignment(Pos.CENTER);
        Label text = new Label("Conversion System");
        text.setFont(Font.font("Arial", 40));
        box1.getChildren().addAll(text);

        // forms
        HBox box2 = buildBox("Enter a Number", "170");
        HBox box3 = buildBox("Binary", "1010101");
        HBox box4 = buildBox("Decimal", "170");
        HBox box5 = buildBox("Hexadecimal", "aa");
        HBox box6 = buildBox("Octal", "252");

        // buttons
        HBox btnBox = new HBox();
        btnBox.setSpacing(5);
        btnBox.setAlignment(Pos.CENTER);
        Button btn1 = new Button("Converter");
        btn1.setPrefWidth(100);
        Button btn2 = new Button("Clear");
        btn2.setPrefWidth(100);
        Button btn3 = new Button("Exit");
        btn3.setPrefWidth(100);
        btnBox.getChildren().addAll(btn1, btn2, btn3);

        root.getChildren().addAll(box1, box2, box3, box4, box5, box6, btnBox);

        Scene scene = new Scene(root, 700, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MyForm");
        primaryStage.show();
    }

    HBox buildBox(String label, String text) {
        HBox box = new HBox();
        box.setSpacing(20);
        box.setPadding(new Insets(0, 0, 0, 230));
        Label l = new Label(label);
        l.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        l.setPrefWidth(120);
        TextField t = new TextField(text);
        t.setPrefWidth(70);

        box.getChildren().addAll(l, t);

        return box;
    }
}
