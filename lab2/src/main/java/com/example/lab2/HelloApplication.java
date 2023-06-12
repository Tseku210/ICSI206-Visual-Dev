package com.example.lab2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();

        HBox headerBox = new HBox();
        headerBox.setSpacing(200);
        headerBox.setPadding(new Insets(10));
        VBox lHeader = new VBox();
        Label h1 = new Label("Window Tester UI Test");
        h1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        Label h2 = new Label("   Create a new Window Tester UI test");
        lHeader.getChildren().addAll(h1, h2);
        VBox rHeader = new VBox();
        Image logo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
        ImageView logoView = new ImageView();
        logoView.setImage(logo);
        logoView.setFitWidth(40);
        logoView.setPreserveRatio(true);
        rHeader.getChildren().add(logoView);
        headerBox.getChildren().addAll(lHeader, rHeader);
        Separator sep1 = new Separator();

        // second section
        VBox sec2 = new VBox();
        sec2.setPadding(new Insets(10));
        sec2.setSpacing(5);
        sec2.getChildren().addAll(
                getSec2("Source Folder: ", "pacmanFunctionalText/src", 300),
                getSec2("Package: ", "jpacman", 250)
        );

        Separator sep2 = new Separator();

        //section 3
        VBox sec3 = new VBox();
        sec3.setPadding(new Insets(10));
        sec3.setSpacing(5);
        HBox nameBox = new HBox();
        nameBox.setAlignment(Pos.CENTER_LEFT);
        Label lblName = new Label("Name: ");
        lblName.setPrefWidth(90);
        TextField inputName = new TextField();
        inputName.setPrefWidth(295);
        nameBox.getChildren().addAll(lblName, inputName);

        // sec3 modifiers
        HBox modifierBox = new HBox();
        modifierBox.setAlignment(Pos.CENTER_LEFT);
        Label modifierName = new Label("Modifiers: ");
        modifierName.setPrefWidth(90);
        HBox radioBox = new HBox();
        radioBox.setSpacing(10);
        RadioButton rb1 = new RadioButton("public");
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("default");
        RadioButton rb3 = new RadioButton("private");
        rb3.setDisable(true);
        RadioButton rb4 = new RadioButton("protected");
        rb4.setDisable(true);
        radioBox.getChildren().addAll(rb1, rb2, rb3, rb4);
        modifierBox.getChildren().addAll(modifierName, radioBox);

        HBox superClassBox = new HBox();
        superClassBox.setAlignment(Pos.CENTER_LEFT);
        superClassBox.setSpacing(5);
        Label superName = new Label("Superclass: ");
        superName.setPrefWidth(90);
        ChoiceBox<String> superInput = new ChoiceBox<String>(FXCollections.observableArrayList("com.windowtester.runtime.swing.UITestCaseSwing", "Second", "Third"));
        superInput.setValue("com.windowtester.runtime.swing.UITestCaseSwing");
        superInput.setDisable(true);
        superInput.setPrefWidth(300);
        Button superBtn = new Button("Browse...");
        superBtn.setPrefWidth(100);
        superBtn.setDisable(true);
        superClassBox.getChildren().addAll(superName, superInput, superBtn);

        sec3.getChildren().addAll(nameBox, modifierBox, superClassBox);

        Separator sep3 = new Separator();

        //section 4
        VBox sec4 = new VBox();
        sec4.setPadding(new Insets(10, 10, 50, 10));
        sec4.setSpacing(5);

        HBox checkBox1 = new HBox();
        checkBox1.setAlignment(Pos.CENTER_LEFT);
        CheckBox check1 = new CheckBox();
        check1.setSelected(true);
        check1.setPrefWidth(90);
        Label checkLbl1 = new Label("Create folders automatically if they do not exist");
        checkBox1.getChildren().addAll(check1, checkLbl1);

        HBox checkBox2 = new HBox();
        checkBox2.setAlignment(Pos.CENTER_LEFT);
        CheckBox check2 = new CheckBox();
        check2.setSelected(true);
        check2.setPrefWidth(90);
        Label checkLbl2 = new Label("Add build path dependencies automatically");
        checkBox2.getChildren().addAll(check2, checkLbl2);

        sec4.getChildren().addAll(checkBox1, checkBox2);

        Separator sep4 = new Separator();

        HBox sec5 = new HBox();
        sec5.setPadding(new Insets(10));
        HBox questionLogoBox = new HBox();
        questionLogoBox.setPrefWidth(270);
        Image questionLogo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("question.png")));
        ImageView questionLogoView = new ImageView();
        questionLogoView.setImage(questionLogo);
        questionLogoView.setFitWidth(20);
        questionLogoView.setPreserveRatio(true);
        questionLogoBox.getChildren().add(questionLogoView);

        HBox btns = new HBox();
        btns.setSpacing(10);
        Button finishBtn = new Button("Finish");
        finishBtn.setPrefWidth(100);
        finishBtn.setDisable(true);
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setPrefWidth(100);
        btns.setAlignment(Pos.CENTER_RIGHT);
        btns.getChildren().addAll(finishBtn, cancelBtn);
        sec5.getChildren().addAll(questionLogoBox, btns);


        root.getChildren().addAll(headerBox, sep1, sec2, sep2, sec3, sep3, sec4, sep4, sec5);
        Scene scene = new Scene(root, 500, 400);
        stage.setTitle("New UI Test");
        stage.setScene(scene);
        stage.show();
    }

    public HBox getSec2(String lblName, String inptName, int inptWidth) {
        HBox box = new HBox();
        box.setSpacing(5);
        box.setAlignment(Pos.CENTER_LEFT);
        Label label = new Label(lblName);
        label.setPrefWidth(90);
        HBox inputBox = new HBox();
        inputBox.setPrefWidth(300);
        TextField input = new TextField(inptName);
        input.setPrefWidth(inptWidth);
        inputBox.getChildren().add(input);
        Button btn = new Button("Browse...");
        btn.setPrefWidth(100);
        box.getChildren().addAll(label, inputBox, btn);

        return box;
    }

    public static void main(String[] args) {
        launch();
    }
}