package com.example.visual_lab6;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListController {
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnRemoveAll;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField tfText;

    @FXML
    private AnchorPane scrollLanguages;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ListView<String> listView;

    @FXML
    void onAdd(ActionEvent event) {
        programmingLanguages.add(tfText.getText());
    }

    @FXML
    void onRemove(ActionEvent event) {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            programmingLanguages.remove(selectedIndex);
        }
    }

    @FXML
    void onRemoveAll(ActionEvent event) {
        programmingLanguages.clear();
    }

    @FXML
    void onUpdate(ActionEvent event) {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            String newValue = tfText.getText();
            programmingLanguages.set(selectedIndex, newValue);
            listView.setItems(programmingLanguages);
        }
    }
    private final ObservableList<String> programmingLanguages = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        programmingLanguages.addAll("Java", "Python", "JavaScript", "C++", "Swift");
        listView = new ListView<String>(programmingLanguages);
        scrollPane.setContent(listView);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                tfText.setText(t1);
            }
        });


        VBox vbox = new VBox();
        for (String language : programmingLanguages) {
            Label lbl = new Label(language);
            vbox.getChildren().add(lbl);
        }

    }
}
