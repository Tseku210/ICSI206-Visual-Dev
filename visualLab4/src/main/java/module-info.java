module com.example.visuallab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visuallab4 to javafx.fxml;
    exports com.example.visuallab4;
}