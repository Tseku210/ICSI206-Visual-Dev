module com.example.visual_lab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visual_lab5 to javafx.fxml;
    exports com.example.visual_lab5;
}