package com.example.visual_lab13_v2;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import com.mysql.cj.jdbc.Driver;

import java.util.HashMap;

public class MainController {
    @FXML
    void printAction(ActionEvent event) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                HashMap parameters = new HashMap();
                JasperPrint js = JasperFillManager.fillReport("", parameters)
                return null;
            }
        };
    }
}