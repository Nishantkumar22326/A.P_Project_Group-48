package com.example.javafxtutorial;



import javafx.animation.Timeline;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.io.IOException;
import  javafx.application.Platform;

import javax.sound.sampled.*;


public class scenesController   {

    @FXML
    private AnchorPane pane;
    @FXML
    private Button load1;
    @FXML
    private Button load2;
    @FXML
    private Button load3;
    @FXML
    private Button load4;
    private Stage stage;
    private Scene scene;
    @FXML
    private volatile Rectangle stick;
    @FXML
    private AnchorPane pane2;
    @FXML
    private Button increaseButton;

    @FXML
    ImageView imageView;
    @FXML
    ImageView Cherry_imageView;
    @FXML
    Label Score;
    @FXML
    Label Cherry;

    static int pillarSwitch=1;


    static private int current_score=0;
    static volatile private int current_Cherry=0;
    static volatile private int SC_Cherry=0;
    private static volatile  int imageangle=0;
    private static volatile  double heroupX=0;
    private static volatile  double herodownX=0;


    @FXML
    Rectangle pillar1;
    @FXML
    Rectangle pillar2;
    @FXML
    private Button restart;
    @FXML
    private Button continuePlay;
    static  volatile private int SC_score;
    private TranslateTransition transition;
    private Rotate rotateTransform,move_down;
    private double  initialStickY=434;

    private static final double INCREASE_AMOUNT = 1.0;
 private double sceneWidth=360 ;
 @FXML
 private Button pause;
@FXML
private Button ReVive;
 private Thread mainThread;
 private volatile boolean exitThread = false;
 static  private volatile int save = 0;


 private volatile boolean save_loadSwitch = false;
private static volatile  int revive_Cherry = 1;

 SaveData saveData= new SaveData();

    static volatile Clip clip;
    Game_controller gameControllerInstance = Game_controller.getInstance();

    private static ArrayList<Double> PW;


    private final Semaphore semaphore = new Semaphore(1);

    public void initialize() {

        if (increaseButton != null) {
            if(restart.isVisible()){
                restart.setDisable(true);
                restart.setVisible(false);
                continuePlay.setDisable(true);
                continuePlay.setVisible(false);
                ReVive.setDisable(true);
                ReVive.setVisible(false);
                pause.setDisable(false);
                pause.setVisible(true);
            }
            PW = Pillar.getDoubleList();
            pillarSwitch=1;

            new Thread(() -> {
                while (!exitThread) {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    Platform.runLater(() -> {


                        stick.setHeight(5);
                        Score.setText("Score" + current_score);
                        System.out.println("Cherry_I"+current_Cherry);
                        Cherry.setText(String.valueOf(current_Cherry));
                        increaseButton.setOnMousePressed(event -> handleButtonPress());
                        increaseButton.setOnMouseReleased(event -> {
                            try {
                                handleButtonRelease();
                            } catch (UnsupportedAudioFileException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (LineUnavailableException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        pause.setOnAction(event -> {

                            try {
                                switchToscene3(event);
                                exitThread = true;
                                semaphore.release();
                                SC_score=current_score;
                                SC_Cherry = current_Cherry;
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });


                        ReVive.setOnAction(event -> {

                            try {
                                exitThread = true;
                                semaphore.release();
                                SC_score = current_score;
                                SC_Cherry = current_Cherry - revive_Cherry;
                                switchToscene1(event);

                                revive_Cherry =revive_Cherry* 2;
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (UnsupportedAudioFileException e) {
                                throw new RuntimeException(e);
                            } catch (LineUnavailableException e) {
                                throw new RuntimeException(e);
                            }
                        });


                        restart.setOnAction(event -> {
                            try {
                                SC_Cherry=0;
                                SC_score=0;
                                switchToscene1(event);
                                exitThread = true;
                                semaphore.release();
                            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        continuePlay.setOnAction(event -> {
                            try {
                                switchToscene3(event);
                                exitThread = true;
                                semaphore.release();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        rotateTransform = new Rotate();
                        rotateTransform.setAxis(Rotate.Z_AXIS);
                        move_down = new Rotate();
                        Point3D point = new Point3D(1,0,0);
                        move_down.setAxis(point);

                        imageangle=-1;
                        move_down.setPivotX(imageView.getFitWidth());
                        move_down.setPivotY( imageView.getFitHeight()-2);

                        transition = new TranslateTransition();
                        transition.setNode(imageView);
                        transition.setDuration(Duration.millis(1000));
                        transition.setAutoReverse(true);
                        transition.setByX(200);

                        rotateTransform.setPivotX(stick.getWidth() / 2);
                        rotateTransform.setPivotY(stick.getHeight());

                        stick.getTransforms().add(rotateTransform);
                        imageView.getTransforms().add(move_down);
                        generateRandomPillars();

                        pane2.setOnMousePressed(event -> handleDownButtonPress());



                    });

                    try {
                        Thread.sleep(1000); // Adjust the sleep time as needed
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                    // Sleep to control the loop speed

                }
            }).start();

            if (load1 != null){
                load1.setOnAction(event -> {
                    if(save==0){
                        save_loadSwitch=true;

                    }
                    else {
                        save_loadSwitch=false;
                    }
                    try {
                        loadgame1(event);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                });
                load2.setOnAction(event -> {
                    if(save==0){
                        save_loadSwitch=true;

                    }
                    else {
                        save_loadSwitch=false;
                    }
                    try {
                        loadgame2(event);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                });
                load3.setOnAction(event -> {
                    if(save==0){
                        save_loadSwitch=true;

                    }
                    else {
                        save_loadSwitch=false;
                    }
                    try {
                        loadgame3(event);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                });
                load4.setOnAction(event -> {
                    if(save==0){
                        save_loadSwitch=true;

                    }
                    else {
                        save_loadSwitch=false;
                    }
                    try {
                        loadgame4(event);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                });

            }

        }
    }
    private void handleDownButtonPress() {
        // Rotate the imageView by 180 degrees
        if(imageangle == -1 ){

        }
        else if (imageangle == 0)
        {
            move_down.setAngle(180);
            imageangle=1;
            imageView.setLayoutY(imageView.getLayoutY()-5);
            herodownX=imageView.getTranslateX();

        }
        else
        {
            imageView.setLayoutY(imageView.getLayoutY()+5);
            heroupX = imageView.getTranslateX();
            move_down.setAngle(0);
            imageangle=0;
        }


        double xCoordinate = imageView.getTranslateX();
        System.out.println("X-coordinate of imageView: " + xCoordinate);
    }

    private void generateRandomPillars() {
        // Assuming 'pane' is the parent of pillars

        // Set the width of the pillars (you can adjust this as needed)
//        pillar1.setWidth(pillar2.getWidth());
        pillar2.setWidth(PW.get(pillarSwitch));
        pillarSwitch=(pillarSwitch+1)% PW.size();
        double pillarWidth = pillar1.getWidth();
        Random random = new Random();
        pillar1.setX(0);
        pillar2.setX(0);


        // Generate a random position for pillar1
        double pillar1X = random.nextDouble(sceneWidth / 2.0);
        pillar1.setLayoutX(pillar1X);
        imageView.setY(0);
        imageView.setLayoutX(pillar1X - 3);
        stick.setLayoutX(pillar1X + pillarWidth - 2);
        stick.setVisible(true);
        stick.setY(0);
        stick.setLayoutY(initialStickY);
        //added
        // Generate a random position for pillar2 while ensuring it doesn't exceed the scene width
        double maxAllowedDistance = sceneWidth - pillarWidth - pillar1.getLayoutX() - 20;

        double pillar2X = random.nextDouble((maxAllowedDistance)) + pillar1.getLayoutX() + 20;
        while (pillar2X - pillar1X - pillarWidth < 0) {
            pillar2X = random.nextDouble((maxAllowedDistance)) + pillar1.getLayoutX() ;
        }
        if(pillar2X-pillar1.getLayoutX()<50){
            pillar2X+=50;
        }

        //added
        double cherryX= random.nextDouble(pillar2X-pillar1.getWidth()-pillar1X)+pillar1X+pillarWidth;
        while (cherryX+10>=pillar2X){
            cherryX-=3;

        }
        while (pillar1X+pillar1.getWidth()>=cherryX) {
            cherryX+=3;
        }
        Cherry_imageView.setX(0);
        Cherry_imageView.setLayoutX(cherryX);
        System.out.println("pillar2 x : " + pillar2X);
        System.out.println("pillar1 x : " + pillar1.getLayoutX());
        System.out.println("Distance : " + (pillar2X - pillar1X - pillarWidth));

        pillar2.setLayoutX(pillar2X);
    }


    public void switchToscene1(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException{
        Game_controller.st=0;
        gameControllerInstance.playSound("backgroundmusic");
        current_score=SC_score;
        current_Cherry=SC_Cherry;

        // Load the scene
        Parent root1 = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToscene2(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        SC_score=0;
        SC_Cherry=0;
        save=0;
        stage.setScene(scene);
        stage.show();
    }

    public void switchToscene3(ActionEvent event) throws IOException {
        stopBackgroundMusic();
        Parent root1 = FXMLLoader.load(getClass().getResource("scene3.fxml"));
        save=1;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }






    public void switchToscene4(ActionEvent event) throws IOException {
        stopBackgroundMusic();
        Parent root1 = FXMLLoader.load(getClass().getResource("scene4.fxml"));


        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }

    public void increaseStick() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        // Increase the height of the stick
        if(stick.getHeight()<360-pillar1.getLayoutX()){
            gameControllerInstance.playSound("increasestick");

            stick.setHeight(stick.getHeight() + INCREASE_AMOUNT);

            stick.setY(stick.getY() - INCREASE_AMOUNT);
        }

    }

    public void handleButtonPress() {
        stopBackgroundMusic();
        // Start the Timeline when the button is pressed
        if (increaseButton != null) {


            new Thread(() -> {
                while (increaseButton.isPressed()) {
                    try {
                        Thread.sleep(30); // Adjust the sleep time as needed
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        increaseStick();
                    } catch (LineUnavailableException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (UnsupportedAudioFileException e) {
                        throw new RuntimeException(e);
                    }
                }

            }).start();
        }
    }
    private void stopBackgroundMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    public void handleButtonRelease() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Stop the Timeline when the button is released
        if (increaseButton != null){

            transition.setByX(stick.getHeight()+(pillar1.getX()+pillar1.getWidth()-imageView.getX()));


            increaseButton.setVisible(false);
            increaseButton.setDisable(true);

            System.out.println("Stick Height :"+ stick.getHeight() );
            // Start the rotation animation

            // stick rotate sound
            gameControllerInstance.playSound("stickrotate");

            rotateTransform.setAngle(90); // Set the desired rotation angle
            transition.play();
            imageangle=0;

            transition.setOnFinished(event -> {
                stick.setVisible(false);
                stick.setLayoutY(initialStickY);
                rotateTransform.setAngle(0);
                System.out.println("Rotated");
                imageView.setX(0);
                imageView.setTranslateX(0);


                if((stick.getHeight()>=(pillar2.getLayoutX()-pillar1.getLayoutX()- pillar1.getWidth())-2 && stick.getHeight()<(pillar2.getLayoutX()-pillar1.getLayoutX()- pillar1.getWidth())+ pillar2.getWidth())){
                    // victory
                    gameControllerInstance.playSound("victory");

                    System.out.println("Again");
                    current_score+=10;
                    Score.setText("Score"+current_score);


                    //score sound
                    gameControllerInstance.playSound("score");


                    increaseButton.setVisible(true);
                    increaseButton.setDisable(false);
                }
                else {
                        pause.setDisable(true);
                        pause.setVisible(false);

                    // hero falls sound
                    gameControllerInstance.playSound("herofalls");

                    transition.setByY(100);
                    transition.play();
                    transition.setOnFinished(event1 ->{
                        imageView.setVisible(false);
                        imageView.setTranslateY(0);
                        imageView.setX(0);
                        imageView.setTranslateX(0);
                    } );

                    // Call the switchToscene3 method

                        restart.setVisible(true);
                        restart.setDisable(false);
                        continuePlay.setDisable(false);
                        continuePlay.setVisible(true);
                        if (current_Cherry>=revive_Cherry){
                        ReVive.setDisable(false);
                        ReVive.setVisible(true);
                        }
                        exitThread = true;




                }
//                System.out.println("hero down loc"+herodownX+imageView.getLayoutX());
//                System.out.println("hero up loc"+heroupX+imageView.getLayoutX());
//                System.out.println("Cherry "+Cherry_imageView.getLayoutX());

                if( herodownX+imageView.getLayoutX() -10<= Cherry_imageView.getLayoutX()&& heroupX+imageView.getLayoutX() +20>= Cherry_imageView.getLayoutX()){
                    current_Cherry+=1;
                    System.out.println("hero down loc"+herodownX);
                    System.out.println("hero down loc"+heroupX);

                    System.out.println("Cherry collected");


                }
                if (heroupX==0 && herodownX>0) {
                    gameControllerInstance.playSound("herofalls");

                    transition.setByY(100);
                    transition.play();
                    transition.setOnFinished(event1 ->{
                        imageView.setVisible(false);
                        imageView.setTranslateY(0);
                        imageView.setX(0);
                        imageView.setTranslateX(0);
                        pause.setDisable(true);
                        pause.setVisible(false);
                    } );

                    // Call the switchToscene3 method

                    restart.setVisible(true);
                    restart.setDisable(false);
                    continuePlay.setDisable(false);
                    continuePlay.setVisible(true);
                    if (current_Cherry>=revive_Cherry){

                    ReVive.setDisable(false);
                    ReVive.setVisible(true);
                    }
                    herodownX=0;
                    heroupX=0;

                    exitThread=true;
                }

                semaphore.release();
                heroupX=0;
                herodownX=0;

            });




        }
    }
// ________________________Save&load________________________________

    public void loadgame1(ActionEvent event) throws IOException{
        Parent root1 = null;
        try {
            root1 = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //loading case
        if(save==0){

//            saveData.DataEntry=SaveData.map.get("load1");
                int[] retriveddataa= SaveData.saveData.getGameData("load1");
                SC_score=retriveddataa[1];
                SC_Cherry= retriveddataa[0];
            System.out.println("Load Cherry"+SC_Cherry);
            System.out.println("Score"+ SC_score);

        }
        //save case
        else {

            SaveData.saveData.saveData("load1",SC_Cherry,SC_score);
        }
        save=0;
        save_loadSwitch=false;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        current_score=SC_score;
        current_Cherry=SC_Cherry;
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    public void loadgame2(ActionEvent event) throws  IOException{
        Parent root1 = null;
        try {
            root1 = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //loading case
        if(save==0){

//            saveData.DataEntry=SaveData.map.get("load1");
            int[] retriveddataa= SaveData.saveData.getGameData("load2");
            SC_score=retriveddataa[1];
            SC_Cherry= retriveddataa[0];
        }
        //save case
        else {
            SaveData.saveData.saveData("load2",SC_Cherry,SC_score);

        }
        save=0;
        save_loadSwitch=false;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        current_score=SC_score;
        current_Cherry=SC_Cherry;
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    public void loadgame3(ActionEvent event) throws  IOException{
        Parent root1 = null;
        try {
            root1 = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //loading case
        if(save==0){

//            saveData.DataEntry=SaveData.map.get("load1");
            int[] retriveddataa= SaveData.saveData.getGameData("load3");
            SC_score=retriveddataa[1];
            SC_Cherry= retriveddataa[0];
            System.out.println("Cherry "+SC_Cherry);
            System.out.println("Score "+SC_score);

        }
        //save case
        else {
            SaveData.saveData.saveData("load3",SC_Cherry,SC_score);

        }
        save=0;
        save_loadSwitch=false;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        current_score=SC_score;
        current_Cherry=SC_Cherry;
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    public void loadgame4(ActionEvent event) throws  IOException {
        Parent root1 = null;
        try {
            root1 = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //loading case
        if(save==0){

//            saveData.DataEntry=SaveData.map.get("load1");
            int[] retriveddataa= SaveData.saveData.getGameData("load4");
            SC_score=retriveddataa[1];
            SC_Cherry= retriveddataa[0];
        }
        //save case
        else {
            SaveData.saveData.saveData("load4",SC_Cherry,SC_score);

        }
        save=0;
        save_loadSwitch=false;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        current_score=SC_score;
        current_Cherry=SC_Cherry;
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }



    public void close(ActionEvent event) {
        stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }


    }
