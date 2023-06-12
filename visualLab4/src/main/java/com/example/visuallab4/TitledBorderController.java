package com.example.visuallab4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TitledBorderController {
//    @FXML
//    private TextField tfPassword;
//
//    @FXML
//    private TextField tfUserName;
//
//
//    @FXML
//    void login(ActionEvent event) {
//        boolean pass = false;
//        if (tfPassword.getText().equals("OTTO") &&
//                tfUserName.getText().equals("luvsa@hot.com")) {
//            pass = true;
//        }
//
//        if (pass) {
//            System.out.println("Ta amjilttai nevterlee");
//        } else {
//            System.out.println("Ta hen be?");
//        }
//    }

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_exit;


    @FXML
    private TextField num_first;

    @FXML
    private TextField num_second;

    @FXML
    private TextField result;

    @FXML
    void onAdd(ActionEvent event) {
        int num1 = Integer.parseInt(num_first.getText());
        int num2 = Integer.parseInt(num_second.getText());
        int rslt = num1 + num2;
        result.setText(String.valueOf(rslt));
    }

    @FXML
    void onClear(ActionEvent event) {
        num_first.clear();
        num_second.clear();
        result.clear();
    }

    @FXML
    void onExit(ActionEvent event) {
        Platform.exit();
    }

}