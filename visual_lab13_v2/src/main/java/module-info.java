module com.example.visual_lab13_v2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires mysql.connector.j;


    opens com.example.visual_lab13_v2 to javafx.fxml;
    exports com.example.visual_lab13_v2;
}