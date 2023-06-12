module com.example.visual_lab6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visual_lab6 to javafx.fxml;
    exports com.example.visual_lab6;
}