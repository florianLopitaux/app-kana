module com.example.appkana {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.appkana to javafx.fxml;
    exports com.example.appkana;
}