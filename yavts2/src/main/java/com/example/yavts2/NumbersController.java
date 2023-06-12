package com.example.yavts2;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.*;

public class NumbersController {

    @FXML
    private StackPane eight;

    @FXML
    private StackPane five;

    @FXML
    private StackPane four;

    @FXML
    private StackPane nine;

    @FXML
    private HBox numbers;

    @FXML
    private StackPane one;

    @FXML
    private StackPane seven;

    @FXML
    private StackPane six;

    @FXML
    private HBox stacks;

    @FXML
    private StackPane ten;

    @FXML
    private Label text;

    @FXML
    private StackPane three;

    @FXML
    private StackPane two;

    ObservableList<HBox> numbersList = FXCollections.observableArrayList();
    ObservableList<StackPane> numbersDropList = FXCollections.observableArrayList();

    ObservableList<StackPane> defaultNumbersDropList = FXCollections.observableArrayList();

    String[] colorList = {"red", "brown", "orange", "yellow", "black", "gray", "blue", "purple", "skyblue", "crimson"};

    @FXML
    void onClose(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onReset(ActionEvent event) {
        numbers.getChildren().clear();
        stacks.getChildren().clear();
        numbersInit();
        resetStackPanes();
    }

    void resetStackPanes() {
        for (StackPane stackPane : numbersDropList) {
            stackPane.getChildren().removeIf(node -> node instanceof HBox);
        }
        stacks.getChildren().setAll(defaultNumbersDropList);
    }
    @FXML
    void onSubmit(ActionEvent event) {
        boolean isCorrect = checkAnswer();
        String message = isCorrect ? "Correct!" : "Incorrect!";
        displayResultDialog(message);
    }

    boolean checkAnswer() {
        for (int i = 0; i < numbersDropList.size(); i++) {
            StackPane stackPane = numbersDropList.get(i);
            System.out.println(stackPane.getChildren());
            if (stackPane.getChildren().size() == 2) {
                HBox hbox = (HBox) stackPane.getChildren().get(1);
                Label lbl = (Label) hbox.getChildren().get(0);
                int expectedNumber = i + 1;
                int droppedNumber = Integer.parseInt(lbl.getText());
                if (droppedNumber != expectedNumber) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    void displayResultDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Хариу");
        alert.setHeaderText(null);
        alert.setContentText(message);

        ButtonType okButton = new ButtonType("Дахин тоглох", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(okButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == okButton) {
            onReset(null);
        }
    }

    HBox numberItem(int i) {
        HBox hbox = new HBox();
        Label lbl = new Label(String.valueOf(i));

        lbl.setStyle("-fx-font-size: 28; -fx-font-weight: bold; -fx-text-fill: white;");
        hbox.setStyle("-fx-background-color: gray; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: gray; -fx-border-width: 1;");
        hbox.setPrefWidth(75);
        hbox.setPrefHeight(130);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(lbl);

        hbox.setOnDragDetected(event -> {
            Dragboard db = hbox.startDragAndDrop(TransferMode.MOVE);

            ClipboardContent content = new ClipboardContent();
            content.put(DataFormat.PLAIN_TEXT, String.valueOf(i));
            db.setContent(content);

            event.consume();
        });

        return hbox;
    }

    void numbersInit() {
        numbersList.clear();
        for (int i = 1; i <= 10; i++) {
            numbersList.addAll(numberItem(i));
        }

        Collections.shuffle(numbersList);
        numbers.getChildren().addAll(numbersList);
    }


    private String randomColor() {
        Random random = new Random();
        int index = random.nextInt(colorList.length);
        return colorList[index];
    }

    @FXML
    void initialize() {
        numbersDropList.addAll(one, two, three, four, five, six, seven, eight, nine, ten);
        defaultNumbersDropList.addAll(one, two, three, four, five, six, seven, eight, nine, ten);
        numbersInit();

        for (StackPane stackPane : numbersDropList) {
            stackPane.setOnDragOver(event -> {
                if (event.getGestureSource() != stackPane &&
                        event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            });

            stackPane.setOnDragEntered(event -> {
                if (event.getGestureSource() != stackPane &&
                        event.getDragboard().hasString()) {
                    stackPane.setStyle(stackPane.getStyle() + "-fx-background-color: lightgray;");
                }
            });

            stackPane.setOnDragExited(event -> {
                stackPane.setStyle(stackPane.getStyle() + "-fx-background-color: white;");
            });

            stackPane.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString() && !stackPane.getChildren().isEmpty()) {
                    int droppedNumber = Integer.parseInt(db.getString());
                    System.out.println(droppedNumber);
                    numbersList.removeIf(item -> {
                        Label lbl = (Label) item.getChildren().get(0);
                        int number = Integer.parseInt(lbl.getText());
                        return number == droppedNumber;
                    });

                    System.out.println(numbersList);


                    HBox nItem = numberItem(Integer.parseInt(db.getString()));
                    nItem.setStyle(nItem.getStyle() + "; " + "-fx-background-color: " + randomColor() + ";");
//                    stackPane.getChildren().clear();
                    stackPane.getChildren().add(nItem);

                    success = true;

                    numbers.getChildren().removeIf(item -> {
                        Label lbl = (Label) ((HBox) item).getChildren().get(0);
                        int number = Integer.parseInt(lbl.getText());
                        return number == droppedNumber;
                    });

                    System.out.println(randomColor());
//                    stackPane.setStyle("-fx-background-color: " + randomColor() + ";");
                }
                event.setDropCompleted(success);
                event.consume();
            });
        }

    }
}
