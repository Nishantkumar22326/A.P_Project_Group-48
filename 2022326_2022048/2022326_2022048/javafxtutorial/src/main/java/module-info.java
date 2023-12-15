module com.example.javafxtutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.testng;


    opens com.example.javafxtutorial to javafx.fxml;
    exports com.example.javafxtutorial;
}