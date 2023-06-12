module com.example.vehicle_dealer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vehicle_dealer to javafx.fxml;
    exports com.example.vehicle_dealer;
}