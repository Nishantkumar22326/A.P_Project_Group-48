package com.example.javafxtutorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import  javafx.scene.Parent;




public class sceneControl extends Application {
    private Game_controller gamecontrol;
    @Override
    public void start(Stage stage) throws Exception {

        try{
            Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
            Scene scn = new Scene(root);

            Image icon = new Image(getClass().getResource("/image/running1.png").toExternalForm());
            stage.getIcons().add(icon);
            stage.setScene(scn);
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
