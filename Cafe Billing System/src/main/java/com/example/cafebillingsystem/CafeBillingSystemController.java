package com.example.cafebillingsystem;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

import java.util.Calendar;

public class CafeBillingSystemController {

    @FXML
    private Label time;
    @FXML
    private Label date;
    @FXML
    private TextField drinks;
    @FXML
    private TextField cakes;
    @FXML
    private TextField services;
    @FXML
    private TextField taxs;
    @FXML
    private TextField subs;
    @FXML
    private TextField totals;
    @FXML
    private TextField lbl1;

    @FXML
    private TextField lbl10;

    @FXML
    private Label tf10;
    @FXML
    private TextField lbl11;
    @FXML
    private Label tf1;

    @FXML
    private Label tf11;

    @FXML
    private TextField lbl12;

    @FXML
    private Label tf12;

    @FXML
    private TextField lbl13;

    @FXML
    private Label tf13;

    @FXML
    private TextField lbl14;

    @FXML
    private Label tf14;

    @FXML
    private TextField lbl15;

    @FXML
    private Label tf15;

    @FXML
    private TextField lbl16;

    @FXML
    private Label tf16;

    @FXML
    private TextField lbl2;

    @FXML
    private Label tf2;

    @FXML
    private TextField lbl3;

    @FXML
    private Label tf3;

    @FXML
    private TextField lbl4;

    @FXML
    private Label tf4;

    @FXML
    private TextField lbl5;

    @FXML
    private Label tf5;

    @FXML
    private TextField lbl6;

    @FXML
    private Label tf6;

    @FXML
    private TextField lbl7;

    @FXML
    private Label tf7;

    @FXML
    private TextField lbl8;

    @FXML
    private Label tf8;

    @FXML
    private TextField lbl9;

    @FXML
    private Label tf9;


    @FXML
    void receipt(ActionEvent event) {
        if (!lbl1.getText().isEmpty())
            tf1.setText(lbl1.getText());
        if (!lbl2.getText().isEmpty())
            tf2.setText(lbl2.getText());
        if (!lbl3.getText().isEmpty())
            tf3.setText(lbl3.getText());
        if (!lbl4.getText().isEmpty())
            tf4.setText(lbl4.getText());
        if (!lbl5.getText().isEmpty())
            tf5.setText(lbl5.getText());
        if (!lbl6.getText().isEmpty())
            tf6.setText(lbl6.getText());
        if (!lbl7.getText().isEmpty())
            tf7.setText(lbl7.getText());
        if (!lbl8.getText().isEmpty())
            tf8.setText(lbl8.getText());
        if (!lbl9.getText().isEmpty())
            tf9.setText(lbl9.getText());
        if (!lbl10.getText().isEmpty())
            tf10.setText(lbl10.getText());
        if (!lbl11.getText().isEmpty())
            tf11.setText(lbl11.getText());
        if (!lbl12.getText().isEmpty())
            tf12.setText(lbl12.getText());
        if (!lbl13.getText().isEmpty())
            tf13.setText(lbl13.getText());
        if (!lbl14.getText().isEmpty())
            tf14.setText(lbl14.getText());
        if (!lbl15.getText().isEmpty())
            tf15.setText(lbl15.getText());
        if (!lbl16.getText().isEmpty())
            tf16.setText(lbl16.getText());
    }

    private int minute;
    private int hour;
    private int second;
    private int am;
    private String ext;

    private int day;
    private int month;
    private int year;

    @FXML
    public void initialize() {

        Thread clock = new Thread() {
            public void run() {

                Calendar cal = Calendar.getInstance();

                second = cal.get(Calendar.SECOND);
                minute = cal.get(Calendar.MINUTE);
                hour = cal.get(Calendar.HOUR);
                am = cal.get(Calendar.AM);

                if (am == 0)
                    ext = "AM";
                else
                    ext = "PM";

                time.setText(hour + ":" + (minute) + ":" + second + " " + ext);

                month = cal.get(Calendar.MONTH);
                day = cal.get(Calendar.DATE);
                year = cal.get(Calendar.YEAR);
                date.setText(month + "/" + day + "/" + year);

            }

        };
        clock.start();
    }

    @FXML
    void calculate(ActionEvent event) {
        int drink = 0;

        if (!lbl1.getText().isEmpty())
            drink += Integer.parseInt(lbl1.getText()) * 2000;
        if (!lbl2.getText().isEmpty())
            drink += Integer.parseInt(lbl2.getText()) * 2100;
        if (!lbl3.getText().isEmpty())
            drink += Integer.parseInt(lbl3.getText()) * 2200;
        if (!lbl4.getText().isEmpty())
            drink += Integer.parseInt(lbl4.getText()) * 2300;
        if (!lbl5.getText().isEmpty())
            drink += Integer.parseInt(lbl5.getText()) * 2400;
        if (!lbl6.getText().isEmpty())
            drink += Integer.parseInt(lbl6.getText()) * 2500;
        if (!lbl7.getText().isEmpty())
            drink += Integer.parseInt(lbl7.getText()) * 2600;
        if (!lbl8.getText().isEmpty())
            drink += Integer.parseInt(lbl8.getText()) * 2700;
        drinks.setText("$" + drink);

        int cake = 0;

        if (!lbl9.getText().isEmpty())
            cake += Integer.parseInt(lbl9.getText()) * 2000;
        if (!lbl10.getText().isEmpty())
            cake += Integer.parseInt(lbl10.getText()) * 2100;
        if (!lbl11.getText().isEmpty())
            cake += Integer.parseInt(lbl11.getText()) * 2200;
        if (!lbl12.getText().isEmpty())
            cake += Integer.parseInt(lbl12.getText()) * 2300;
        if (!lbl13.getText().isEmpty())
            cake += Integer.parseInt(lbl13.getText()) * 2400;
        if (!lbl14.getText().isEmpty())
            cake += Integer.parseInt(lbl14.getText()) * 2500;
        if (!lbl15.getText().isEmpty())
            cake += Integer.parseInt(lbl15.getText()) * 2600;
        if (!lbl16.getText().isEmpty())
            cake += Integer.parseInt(lbl16.getText()) * 2700;
        cakes.setText("$" + cake);
        double service = (double) (drink + cake) / 100;
        services.setText("$" + service);
        double tax = (double) (drink + cake) / 10;
        taxs.setText("$" + tax);
        double sub = drink + cake + service;
        subs.setText("$" + sub);
        double total = tax + sub;
        totals.setText("$" + total);
    }

    @FXML
    void reset(ActionEvent event) {
        lbl1.clear();
        lbl2.clear();
        lbl3.clear();
        lbl4.clear();
        lbl5.clear();
        lbl6.clear();
        lbl7.clear();
        lbl8.clear();
        lbl9.clear();
        lbl10.clear();
        lbl11.clear();
        lbl12.clear();
        lbl13.clear();
        lbl14.clear();
        lbl15.clear();
        lbl16.clear();

        drinks.clear();
        cakes.clear();
        services.clear();
        taxs.clear();
        subs.clear();
        totals.clear();

        tf1.setText("0");
        tf2.setText("0");
        tf3.setText("0");
        tf4.setText("0");
        tf5.setText("0");
        tf6.setText("0");
        tf7.setText("0");
        tf8.setText("0");
        tf9.setText("0");
        tf10.setText("0");
        tf11.setText("0");
        tf12.setText("0");
        tf13.setText("0");
        tf14.setText("0");
        tf15.setText("0");
        tf16.setText("0");
    }

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

}