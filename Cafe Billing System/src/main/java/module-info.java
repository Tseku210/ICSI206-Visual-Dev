module com.example.cafebillingsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cafebillingsystem to javafx.fxml;
    exports com.example.cafebillingsystem;
}