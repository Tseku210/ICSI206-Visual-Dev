package com.example.sleepingbeauty;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class awakeSleep extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setSpacing(10);

        //buttons
        HBox btnBox = new HBox();
        btnBox.setStyle("-fx-background-color: #d2d2d2");
        btnBox.setSpacing(10);
        btnBox.setAlignment(Pos.CENTER);
        Button awake = new Button("Awake");
        Button asleep = new Button("Asleep");
        btnBox.getChildren().addAll(awake, asleep);

        btnBox.setPadding(new Insets(10, 20, 10, 20));

        // center face
        StackPane stack = new StackPane();
        Circle circle = new Circle(250, 250, 200);
        circle.setFill(Color.YELLOW);

        Line leftEye = new Line(0, 250, 100, 250);
        leftEye.setStrokeWidth(5);
        leftEye.setStroke(Color.BLACK);
        leftEye.setTranslateX(-100);
        leftEye.setTranslateY(0);

        Line rightEye = new Line(0, 250, 100, 250);
        rightEye.setStrokeWidth(5);
        rightEye.setStroke(Color.BLACK);
        rightEye.setTranslateX(100);
        rightEye.setTranslateY(0);

        Circle leftCircle = new Circle(0, Color.BLACK);
        Circle rightCircle = new Circle(0, Color.BLACK);
        leftCircle.setTranslateX(-100);
        rightCircle.setTranslateX(100);

        stack.getChildren().addAll(circle, leftEye, rightEye, leftCircle, rightCircle);

        root.getChildren().addAll(btnBox, stack);

        awake.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                leftEye.setStrokeWidth(0);
                rightEye.setStrokeWidth(0);
                leftCircle.setRadius(50);
                rightCircle.setRadius(50);
            }
        });

        asleep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                leftEye.setStrokeWidth(5);
                rightEye.setStrokeWidth(5);
                leftCircle.setRadius(0);
                rightCircle.setRadius(0);
            }
        });

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sleepy");
        primaryStage.show();
    }
}
