module com.example.db_demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.db_demo2 to javafx.fxml;
    exports com.example.db_demo2;
}