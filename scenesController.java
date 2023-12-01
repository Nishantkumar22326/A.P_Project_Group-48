package com.example.javafxtutorial;



import javafx.animation.Timeline;
import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.concurrent.Semaphore;
import java.io.IOException;
import  javafx.application.Platform;


public class scenesController {

    @FXML
    private AnchorPane pane;

    private Stage stage;
    private Scene scene;
    @FXML
    private Rectangle stick;
    @FXML
    private Button increaseButton;

    @FXML
    ImageView imageView;
    @FXML
    Rectangle pillar1;
    @FXML
    Rectangle pillar2;

    private TranslateTransition transition;
    private Rotate rotateTransform;



    private static final double INCREASE_AMOUNT = 1.0;
 private double sceneWidth=360 ;
 @FXML
 private Button pause;
 private Thread mainThread;
 private volatile boolean exitThread = false;
    private final Semaphore semaphore = new Semaphore(1);

    public void initialize() {

        if (increaseButton != null) {


//
//            stick.setHeight(5);
//            increaseButton.setOnMousePressed(event -> handleButtonPress());
//            increaseButton.setOnMouseReleased(event -> handleButtonRelease());
//            pause.setOnAction(event -> {
//                try {
//                    switchToscene3(event);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            rotateTransform = new Rotate();
//            rotateTransform.setAxis(Rotate.Z_AXIS);
//
//            transition = new TranslateTransition();
//            transition.setNode(imageView);
//            transition.setDuration(Duration.millis(1000));
//            transition.setAutoReverse(true);
//            transition.setByX(200);
//
//            // Set initial pivot for rotation (lowest point of the stick)
//            rotateTransform.setPivotX( stick.getWidth() / 2);
//            rotateTransform.setPivotY( stick.getHeight());
//            stick.getTransforms().add(rotateTransform);
//
//            // Generate pillars with random distances
//            generateRandomPillars();

            new Thread(() -> {
                while (!exitThread) {
                    try {
                        semaphore.acquire(); // Acquire the permit, blocking if necessary
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // UI-related initialization logic
                    Platform.runLater(() -> {
                        stick.setHeight(5);
                        increaseButton.setOnMousePressed(event -> handleButtonPress());
                        increaseButton.setOnMouseReleased(event -> handleButtonRelease());
                        pause.setOnAction(event -> {
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

                        transition = new TranslateTransition();
                        transition.setNode(imageView);
                        transition.setDuration(Duration.millis(1000));
                        transition.setAutoReverse(true);
                        transition.setByX(200);

                        // Set initial pivot for rotation (lowest point of the stick)
                        rotateTransform.setPivotX(stick.getWidth() / 2);
                        rotateTransform.setPivotY(stick.getHeight());
                        stick.getTransforms().add(rotateTransform);

                        // Generate pillars with random distances
                        generateRandomPillars();

                    });

                    try {
                        Thread.sleep(1000); // Adjust the sleep time as needed
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                    // Sleep to control the loop speed

                }
            }).start();






        }
    }


    private void generateRandomPillars() {
         // Assuming 'pane' is the parent of pillars

        // Set the width of the pillars (you can adjust this as needed)
        double pillarWidth = pillar1.getWidth();
        Random random = new Random();

        // Generate a random position for pillar1
        double pillar1X =  random.nextDouble(sceneWidth/2.0);
        pillar1.setLayoutX(pillar1X);
        imageView.setLayoutX(pillar1X-3);
        stick.setLayoutX(pillar1X+pillarWidth-2);

        // Generate a random position for pillar2 while ensuring it doesn't exceed the scene width
        double maxAllowedDistance = sceneWidth - pillarWidth-pillar1.getLayoutX()-20;

        double pillar2X =   random.nextDouble((maxAllowedDistance))+pillar1.getLayoutX()+20;

        System.out.println("pillar2 x : "+pillar2X);
        System.out.println("pillar1 x : "+pillar1.getLayoutX());

        pillar2.setLayoutX(pillar2X);
    }




    public void switchToscene1(ActionEvent event) throws IOException {
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
        stage.setScene(scene);
        stage.show();
    }

    public void switchToscene3(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("scene3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }

    //save and load scene

    public void switchToscene4(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("scene4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }

    public void increaseStick() {
        // Increase the height of the stick
        if(stick.getHeight()<360-pillar1.getLayoutX()){
            stick.setHeight(stick.getHeight() + INCREASE_AMOUNT);
            stick.setY(stick.getY() - INCREASE_AMOUNT);
        }

    }

    public void handleButtonPress() {
        // Start the Timeline when the button is pressed
        if (increaseButton != null) {
//        increaseTimeline.play();

            new Thread(() -> {
                while (increaseButton.isPressed()) {
                    try {
                        Thread.sleep(100); // Adjust the sleep time as needed
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    increaseStick();
                }

            }).start();
        }
    }

    public void handleButtonRelease() {
        // Stop the Timeline when the button is released
        if (increaseButton != null){

            transition.setByX(stick.getHeight()+(pillar1.getX()+pillar1.getWidth()-imageView.getX()));
//        increaseTimeline.stop();

            increaseButton.setVisible(false);
            increaseButton.setDisable(true);


            // Start the rotation animation
            rotateTransform.setAngle(90); // Set the desired rotation angle
            transition.play();
            if((stick.getHeight()>=(pillar2.getLayoutX()-pillar1.getLayoutX())-2 && stick.getHeight()<(pillar2.getLayoutX()-pillar1.getLayoutX())+5)){

                System.out.println("Again");

            }
            semaphore.release();
            increaseButton.setVisible(true);
            increaseButton.setDisable(false);
        }
    }

    public void close(ActionEvent event) {
        stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
}
