module com.example.student_record {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.student_record to javafx.fxml;
    exports com.example.student_record;
}