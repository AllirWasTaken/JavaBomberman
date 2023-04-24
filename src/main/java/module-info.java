module com.example.javabomberman {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javabomberman to javafx.fxml;
    exports com.example.javabomberman;
}