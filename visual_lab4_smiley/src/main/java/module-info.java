module com.example.visual_lab4_smiley {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visual_lab4_smiley to javafx.fxml;
    exports com.example.visual_lab4_smiley;
}