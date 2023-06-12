module com.example.db_demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.db_demo to javafx.fxml;
    exports com.example.db_demo;
}