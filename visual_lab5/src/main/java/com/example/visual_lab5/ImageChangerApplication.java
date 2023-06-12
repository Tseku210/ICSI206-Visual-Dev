package com.example.visual_lab5;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class ImageChangerApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        BorderPane root = new BorderPane();
        Image image1 = new Image(new FileInputStream("/Users/tsenguunotgonbaatar/Documents/visual_dev/visual_lab5/src/main/resources/goku_black.jpeg"));
        Image image2 = new Image(new FileInputStream("/Users/tsenguunotgonbaatar/Documents/visual_dev/visual_lab5/src/main/resources/goku_ultra_instinct.jpeg"));
//        Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("goku_black.jpeg")));
//        Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("goku_ultra_instinct.jpeg")));
        ImageView imageView = new ImageView(image1);
        imageView.setFitWidth(300);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(true);
        root.setCenter(imageView);

        imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imageView.setImage(image2);
            }
        });

        imageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imageView.setImage(image1);
            }
        });

//        Image image2 = new Image(new FileInputStream("/resources/goku_ultra_instince.jpeg"))

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Changer");
        primaryStage.show();
    }
}
