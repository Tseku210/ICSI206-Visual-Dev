package com.example.visual_ass3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.reflect.GenericArrayType;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class hotel extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        VBox topBox = new VBox();
        topBox.setSpacing(10);
        Text h1 = new Text("BAYANGOL HOTEL");
        h1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        LocalDate curDate = java.time.LocalDate.now();
        Text date = new Text("          Today's Date: " + curDate);
        LocalTime curtime = java.time.LocalTime.now();
        Text time = new Text("                           Time: " + curtime);

        topBox.setPadding(new Insets(0, 0, 30, 70));
        topBox.getChildren().addAll(h1, date, time);

        //center
        VBox centerBox = new VBox();
        centerBox.setSpacing(30);
        HBox topCenterBox = new HBox();
        topCenterBox.setSpacing(100);
        StackPane stack1 = getStackPane();
        VBox roomInfoBox = getBorderedBox();

        HBox nightBox = getLabel("Nights: ");
        TextField txtNight = new TextField();
        txtNight.setPrefWidth(100);
        nightBox.getChildren().add(txtNight);

        HBox nightChargeBox = getLabel("Nightly Charge: ");
        TextField txtNightCharge = new TextField();
        txtNightCharge.setPrefWidth(100);
        nightChargeBox.getChildren().add(txtNightCharge);

        Label roomInfo = getBorderLabel("Room Information");

        roomInfoBox.getChildren().addAll(nightBox, nightChargeBox);
        stack1.getChildren().addAll(roomInfoBox, roomInfo);

        StackPane stack2 = getStackPane();
        VBox addChargeBox = getBorderedBox();

        HBox roomServiceBox = getLabel("Room Service: ");
        TextField txtRoomService = new TextField();
        txtRoomService.setPrefWidth(100);
        roomServiceBox.getChildren().add(txtRoomService);

        HBox telephoneBox = getLabel("Telephone: ");
        TextField txtTel = new TextField();
        txtTel.setPrefWidth(100);
        telephoneBox.getChildren().add(txtTel);

        HBox miscBox = getLabel("Misc: ");
        TextField txtMisc = new TextField();
        txtMisc.setPrefWidth(100);
        miscBox.getChildren().add(txtMisc);

        Label addCharge = getBorderLabel("Additional Charges");
        addChargeBox.getChildren().addAll(roomServiceBox, telephoneBox, miscBox);
        stack2.getChildren().addAll(addChargeBox, addCharge);

        topCenterBox.getChildren().addAll(stack1, stack2);

        // center bottom
        StackPane stack3 = getStackPane();
        VBox totalChargesBox = getBorderedBox();

        HBox roomChargesBox = getLabel("Room Charges: ", 130);
        TextField txtRoomCharges = new TextField();
        txtRoomCharges.setPrefWidth(100);
        txtRoomCharges.setDisable(true);
        roomChargesBox.getChildren().add(txtRoomCharges);
        roomChargesBox.setAlignment(Pos.CENTER);

        HBox aditionalChargesBox = getLabel("Additional Charges: ", 130);
        TextField txtAdd = new TextField();
        txtAdd.setPrefWidth(100);
        txtAdd.setDisable(true);
        aditionalChargesBox.getChildren().add(txtAdd);
        aditionalChargesBox.setAlignment(Pos.CENTER);

        HBox subtotalBox = getLabel("Subtotal: ", 130);
        TextField txtSub = new TextField();
        txtSub.setPrefWidth(100);
        txtSub.setDisable(true);
        subtotalBox.getChildren().add(txtSub);
        subtotalBox.setAlignment(Pos.CENTER);

        HBox taxBox = getLabel("Tax: ", 130);
        TextField txtTax = new TextField();
        txtTax.setPrefWidth(100);
        txtTax.setDisable(true);
        taxBox.getChildren().add(txtTax);
        taxBox.setAlignment(Pos.CENTER);

        HBox totalChargeBox = getLabel("Total Charges: ", 130);
        TextField txtTotal = new TextField();
        txtTotal.setPrefWidth(100);
        txtTotal.setDisable(true);
        totalChargeBox.getChildren().add(txtTotal);
        totalChargeBox.setAlignment(Pos.CENTER);

        Label totalCharges = getBorderLabel("Total Charges");

        totalChargesBox.getChildren().addAll(roomChargesBox, aditionalChargesBox, subtotalBox, taxBox, totalChargeBox);
        stack3.getChildren().addAll(totalChargesBox, totalCharges);

        centerBox.getChildren().addAll(topCenterBox, stack3);

        // bottom
        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setSpacing(20);
        bottomBox.setPadding(new Insets(30, 20, 20, 10));
        Button btnCalc = new Button("Calculate Charges");
        btnCalc.setPrefWidth(150);
        Button btnClear = new Button("Clear");
        btnClear.setPrefWidth(150);
        Button btnExit = new Button("Exit");
        btnExit.setPrefWidth(150);
        bottomBox.getChildren().addAll(btnCalc, btnClear, btnExit);

        root.setTop(topBox);
        root.setCenter(centerBox);
        root.setBottom(bottomBox);

        // event handling
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                txtNight.clear();
                txtNightCharge.clear();
                txtRoomService.clear();
                txtTel.clear();
                txtMisc.clear();
                txtRoomCharges.clear();
                txtAdd.clear();
                txtSub.clear();
                txtTax.clear();
                txtTotal.clear();
            }
        });

        btnCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double total = 0;
                int numNight = Integer.parseInt(txtNight.getText());
                double nightFee = Double.parseDouble(txtNightCharge.getText());
                double miscFee = Double.parseDouble(txtMisc.getText());
                double roomServiceFee = Double.parseDouble(txtRoomService.getText());
                double telFee = Double.parseDouble(txtTel.getText());
                double additionalFee = telFee + miscFee + roomServiceFee;
                double roomCharges = numNight * nightFee;
                double subTotal = additionalFee + roomCharges;
                double tax = subTotal * 0.01;
                total = subTotal + tax;

                txtRoomCharges.setText(String.valueOf(roomCharges));
                txtAdd.setText(String.valueOf(additionalFee));
                txtSub.setText(String.valueOf(subTotal));
                txtTax.setText(String.valueOf(tax));
                txtTotal.setText(String.valueOf(total));
            }
        });

        Scene scene = new Scene(root, 600, 550);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Form1");
        primaryStage.show();
    }

    private HBox getLabel(String lbl) {
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(5);
        Label label = new Label(lbl);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setPrefWidth(100);
        box.getChildren().addAll(label);

        return box;
    }

    private HBox getLabel(String lbl, int w) {
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(5);
        Label label = new Label(lbl);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setPrefWidth(w);
        box.getChildren().addAll(label);

        return box;
    }

    private Label getBorderLabel(String lbl) {
        Label label = new Label(lbl);
        label.setStyle("-fx-translate-y: -10px; -fx-translate-x:10px; -fx-background-color: #f5f5f5");
        return label;
    }

    private VBox getBorderedBox() {
        VBox box = new VBox();
        box.setSpacing(5);
        box.setPadding(new Insets(20, 10, 20, 10));
        box.setStyle("-fx-border-color: gray; -fx-border-radius: 5px; -fx-max-height: 100");

        return box;
    }

    private StackPane getStackPane() {
        StackPane stack = new StackPane();
        stack.setStyle("-fx-alignment: top-left");

        return stack;
    }
}
