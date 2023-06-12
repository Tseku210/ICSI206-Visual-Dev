module com.example.visual_lab5_hotel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visual_lab5_hotel to javafx.fxml;
    exports com.example.visual_lab5_hotel;
}