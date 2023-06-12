module com.example.uliral {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.uliral to javafx.fxml;
    exports com.example.uliral;
}