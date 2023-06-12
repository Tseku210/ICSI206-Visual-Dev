package com.example.visual_lab13;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.HashMap;

public class MainController {
    @FXML
    void printAction(ActionEvent event) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                HashMap parameters = new HashMap();

                return null;
            }
        };
    }
}
