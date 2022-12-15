module com.example.appkana {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.projectGroup.appkana to javafx.fxml;
    exports fr.projectGroup.appkana;
    exports fr.projectGroup.appkana.Controller;
    opens fr.projectGroup.appkana.Controller to javafx.fxml;
}