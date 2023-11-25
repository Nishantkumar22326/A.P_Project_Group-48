package com.example.javafxtutorial;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class scenesController  {
    private Stage stage;
    private Parent root;
    private Scene scene;
    public  void  switchToscene1(ActionEvent event) throws IOException {
        Parent root1= FXMLLoader.load(getClass().getResource("scene1.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root1);
        stage.setScene(scene);
        stage.show();

    }
    public  void  switchToscene2(ActionEvent event) throws IOException {
        Parent root1= FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root1);
        stage.setScene(scene);
        stage.show();

    }
    public  void  switchToscene3(ActionEvent event) throws IOException {
        Parent root1= FXMLLoader.load(getClass().getResource("scene3.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    //save and load scene
    public  void  switchToscene4(ActionEvent event) throws IOException {
        Parent root1= FXMLLoader.load(getClass().getResource("scene4.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }




}
