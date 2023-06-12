package com.example.visual_lab5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private Label coordX;

    @FXML
    private Label coordY;

    @FXML
    void moved(MouseEvent event) {
        coordX.setText(String.valueOf(event.getX()));
        coordY.setText(String.valueOf(event.getY()));
    }
}