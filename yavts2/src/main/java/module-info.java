module com.example.yavts2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.yavts2 to javafx.fxml;
    exports com.example.yavts2;
}