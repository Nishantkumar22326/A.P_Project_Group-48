module com.example.javafxtutorial {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxtutorial to javafx.fxml;
    exports com.example.javafxtutorial;
}