module com.example.visual_ass4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visual_ass4 to javafx.fxml;
    exports com.example.visual_ass4;
}