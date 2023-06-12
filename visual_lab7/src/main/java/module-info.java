module com.example.visual_lab7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visual_lab7 to javafx.fxml;
    exports com.example.visual_lab7;
}