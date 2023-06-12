module com.example.visual_lab3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visual_lab3 to javafx.fxml;
    exports com.example.visual_lab3;
}