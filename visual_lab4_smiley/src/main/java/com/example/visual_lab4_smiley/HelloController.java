package com.example.visual_lab4_smiley;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class HelloController {

    @FXML
    private Button asleep;

    @FXML
    private Button awake;

    @FXML
    private Line leftEye;

    @FXML
    private Line rightEye;

    @FXML
    private Circle leftEyeCircle;

    @FXML
    private Circle rightEyeCircle;

    @FXML
    void onAsleep(ActionEvent event) {
        rightEye.setStrokeWidth(3);
        leftEye.setStrokeWidth(3);
        rightEyeCircle.setRadius(0);
        leftEyeCircle.setRadius(0);
    }

    @FXML
    void onAwake(ActionEvent event) {
        rightEye.setStrokeWidth(0);
        leftEye.setStrokeWidth(0);
        rightEyeCircle.setRadius(50);
        leftEyeCircle.setRadius(50);
    }
}