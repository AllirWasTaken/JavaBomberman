module com.example.javabomberman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.management;

    exports AllirEngine to javafx.graphics;
    exports testing to javafx.graphics;
    opens Bomberman to javafx.fxml;
    exports Bomberman;

}