module com.example.appkana {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.projectGroup.appkana to javafx.fxml;
    exports fr.projectGroup.appkana;
}