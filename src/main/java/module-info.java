module com.example.chesssystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chesssystem to javafx.fxml;
    exports com.example.chesssystem;
}