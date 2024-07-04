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
//            File file = new File("C:\\Users\\nisha\\OneDrive\\Desktop\\MostOfThe loop is completed\\AP_Project\\target\\classes\\Music\\Background music.wav");
//            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
//            clip = AudioSystem.getClip();
//            clip.open(audioInputStream);
//            clip.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args)  {
        launch(args);

    }
}


// NEW CODE
//public class sceneControl extends Application {
//    @Override
//    public void start(Stage stage) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
//            Parent root = loader.load();
//            scenesController controller = loader.getController();
//
//            Scene scene = new Scene(root);
//            scene.setOnKeyPressed(event -> {
//                System.out.println(event.getCode());
//                try {
//                    switch (event.getCode()) {
////                        case UP:
////                            controller.increseStick();
////                            break;
//                        case M:
//                            controller.switchToscene2(event);
//                            break;
//                        case C:
//                            controller.switchToscene1(event);
//                            break;
//                        case L:
//                            controller.switchToscene4(event);
//                            break;
//                        case P:
//                            controller.switchToscene4(event);
//                            break;
//                        default:
//                            break;
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//
//            stage.setScene(scene);
//            stage.show();
//
//            // Request focus on a focusable node in the scene (adjust as needed)
//            root.requestFocus();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
