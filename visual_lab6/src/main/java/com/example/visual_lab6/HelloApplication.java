package com.example.visual_lab6;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

class NewStage {

    private String data;

    NewStage(String data)
    {
        this.data = data;
        Stage subStage = new Stage();
        subStage.setTitle("New Stage");

        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 200);

        TextField textField = new TextField(data);
        root.getChildren().add(textField);

        Button btn = new Button("Set Data");
        btn.setOnAction(eve-> {
            this.data = textField.getText();
            subStage.close();
        });

        subStage.setScene(scene);
        subStage.show();
    }
}

public class HelloApplication extends Application {

    private String data;

    public static void main(String[] args) {

        Application.launch(args);
    }

    public void start(Stage primaryStage) {

        primaryStage.setTitle("PrimaryStage");

        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 700, 200);

        TextField tf = new TextField("");
        Button btn = new Button("Open New Stage");
//        btn.setOnAction(eve-> new NewStage());
        btn.setOnAction(eve-> {
            data = tf.getText();
            new NewStage(data);
        });

        root.getChildren().addAll(btn, tf);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}