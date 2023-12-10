package com.example.javafxtutorial;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import  javafx.scene.Parent;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class sceneControl extends Application {
    private Game_controller gamecontrol;
    private Clip clip;

    @Override
    public void start(Stage stage)throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        try{
            FXMLLoader load =new FXMLLoader(getClass().getResource("scene2.fxml"));
            Parent root = load.load();
            load.setController(this);
            Scene scn = new Scene(root);

            stage.setScene(scn);
            stage.setResizable(false);
            System.out.println(System.getProperty("user.dir"));
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args)  {
        launch(args);

    }
}

