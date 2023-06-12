module com.example.lab1_visual {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab1_visual to javafx.fxml;
    exports com.example.lab1_visual;
}