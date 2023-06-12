package com.example.cafebillingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CafeBillingSystem extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(CafeBillingSystem.class.getResource("CafeBillingSystem-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 508);
        stage.setTitle("CAFE BUILDING SYSTEM");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}