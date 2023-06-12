package com.example.visual_lab5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonsApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(30));

        HBox topBox = new HBox();
        topBox.setSpacing(10);
        topBox.setAlignment(Pos.CENTER);
        Label lbl1 = new Label("Энийг мэдрэв: ");
        Label lbl2 = new Label("");
        topBox.getChildren().addAll(lbl1, lbl2);

        HBox middleBox = new HBox();
        middleBox.setAlignment(Pos.CENTER);
        middleBox.setSpacing(30);
        Button okBtn = new Button("OK");
        okBtn.setId("okBtn");
        Button subBtn = new Button("Submit");
        subBtn.setId("subBtn");
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setId("cancelBtn");
        Button exitBtn = new Button("Exit");
        exitBtn.setId("exitBtn");
        middleBox.getChildren().addAll(okBtn, subBtn, cancelBtn, exitBtn);

        HBox botBox = new HBox();
        botBox.setSpacing(10);
        botBox.setAlignment(Pos.CENTER);
        Label lbl3 = new Label("");
        Label lbl4 = new Label("дарагдав");
        botBox.getChildren().addAll(lbl3, lbl4);

        root.setTop(topBox);
        root.setCenter(middleBox);
        root.setBottom(botBox);

        okBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lbl3.setText(okBtn.getText());
            }
        });

        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lbl3.setText(subBtn.getText());
            }
        });

        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lbl3.setText(cancelBtn.getText());
            }
        });

        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        okBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lbl2.setText(okBtn.getId());
            }
        });
        okBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lbl2.setText("");
            }
        });

        subBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lbl2.setText(subBtn.getId());
            }
        });
        subBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lbl2.setText("");
            }
        });

        cancelBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lbl2.setText(cancelBtn.getId());
            }
        });
        cancelBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lbl2.setText("");
            }
        });

        exitBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lbl2.setText(exitBtn.getId());
            }
        });
        exitBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lbl2.setText("");
            }
        });

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
