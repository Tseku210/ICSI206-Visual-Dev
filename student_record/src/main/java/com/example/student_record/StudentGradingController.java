package com.example.student_record;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StudentGradingController {
    @FXML
    private TextField attendaceEG;

    @FXML
    private TextField attendance10;

    @FXML
    private TextField practical20;

    @FXML
    private TextField practitalEG;

    @FXML
    private TextField prelim30;

    @FXML
    private TextField prelimEG;

    @FXML
    private TextField premilGrade;

    @FXML
    private TextField project30;

    @FXML
    private TextField projectEG;

    @FXML
    private TextField remarks;

    @FXML
    private TableView<?> tableOfStudent;

    @FXML
    private TextField tfAttendanceScore;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPracticalScore;

    @FXML
    private TextField tfPrelimScore;

    @FXML
    private TextField tfProjectScore;

    @FXML
    private TextField tfStudentId;

    @FXML
    private TextField tfWrittenScore;

    @FXML
    private TextField written10;

    @FXML
    private TextField writtenEG;


    @FXML
    void DeleteRecord(ActionEvent event) {

    }

    @FXML
    void LoadGrades(ActionEvent event) {

    }

    @FXML
    void SaveRecords(ActionEvent event) {

    }

    @FXML
    void UpdateRecord(ActionEvent event) {

    }

    @FXML
    void clearAllGrades(ActionEvent event) {
        tfAttendanceScore.setText("");
        tfPrelimScore.setText("");
        tfProjectScore.setText("");
        tfPracticalScore.setText("");
        tfWrittenScore.setText("");
        attendaceEG.setText("");
        attendance10.setText("");
        written10.setText("");
        writtenEG.setText("");
        practical20.setText("");
        practitalEG.setText("");
        project30.setText("");
        projectEG.setText("");
        prelim30.setText("");
        prelimEG.setText("");
        remarks.setText("");
        premilGrade.setText("");
    }

    @FXML
    void computeGrades(ActionEvent event) {
        Integer attendScore = Integer.parseInt(tfAttendanceScore.getText().trim());
        Integer writenScore = Integer.parseInt(tfWrittenScore.getText().trim());
        Integer practicalScore = Integer.parseInt(tfPracticalScore.getText().trim());
        Integer projectScore = Integer.parseInt(tfProjectScore.getText().trim());
        Integer prelimScore = Integer.parseInt(tfPrelimScore.getText().trim());
    }

    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void goToBefore(ActionEvent event) {

    }

    @FXML
    void goToFirst(ActionEvent event) {

    }

    @FXML
    void goToLast(ActionEvent event) {

    }

    @FXML
    void goToNext(ActionEvent event) {

    }

    @FXML
    void showDetails(ActionEvent event) {

    }

    public void initialize() {

    }
}