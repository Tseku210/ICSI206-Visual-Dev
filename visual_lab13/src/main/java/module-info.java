module com.example.visual_lab13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visual_lab13 to javafx.fxml;
    exports com.example.visual_lab13;
}