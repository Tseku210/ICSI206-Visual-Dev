package com.example.visual_lab5_hotel;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloController {
    @FXML
    private TextField addCharges;

    @FXML
    private TextField misc;

    @FXML
    private TextField night;

    @FXML
    private TextField nightlyCharge;

    @FXML
    private TextField roomCharges;

    @FXML
    private TextField roomService;

    @FXML
    private TextField subTotal;

    @FXML
    private TextField tax;

    @FXML
    private TextField telephone;

    @FXML
    private TextField totalCharges;

    @FXML
    private Button btnCalc;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnExit;

    @FXML
    private Label date;

    @FXML
    private Label time;

    @FXML
    void initialize() {
        LocalDate curDate = java.time.LocalDate.now();
        date.setText("          Today's Date: " + curDate);
        LocalTime curtime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        time.setText("                           Time: " + curtime);
    }


    @FXML
    void onCalc(ActionEvent event) {
        double total = 0;
        int numNight = Integer.parseInt(night.getText());
        double nightFee = Double.parseDouble(nightlyCharge.getText());
        double miscFee = Double.parseDouble(misc.getText());
        double roomServiceFee = Double.parseDouble(roomService.getText());
        double telFee = Double.parseDouble(telephone.getText());
        double additionalFee = telFee + miscFee + roomServiceFee;
        double roomChargess = numNight * nightFee;
        double subTotall = additionalFee + roomChargess;
        double taxx = subTotall * 0.01;
        total = subTotall + taxx;

        roomCharges.setText(String.valueOf(roomChargess));
        addCharges.setText(String.valueOf(additionalFee));
        subTotal.setText(String.valueOf(subTotall));
        tax.setText(String.valueOf(taxx));
        totalCharges.setText(String.valueOf(total));
    }

    @FXML
    void onClear(ActionEvent event) {
        night.clear();
        nightlyCharge.clear();
        roomService.clear();
        telephone.clear();
        misc.clear();
        roomCharges.clear();
        addCharges.clear();
        subTotal.clear();
        tax.clear();
        totalCharges.clear();
    }

    @FXML
    void onExit(ActionEvent event) {
        Platform.exit();
    }
}