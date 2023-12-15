module com.example.javafxtutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.javafxtutorial to javafx.fxml;
    exports com.example.javafxtutorial;
}