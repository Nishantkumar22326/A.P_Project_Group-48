package com.example.javafxtutorial;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StickHeroCharacter implements Movable {
    @FXML
    private ImageView stickHeroCharacter;
    private Point2D position ;
    private double stick_length;
    private  int score;

    //adding image1 to stick hero character class
    public void initialize() {
        if (stickHeroCharacter != null) {
            // Load the image
            Image stickHeroImage = new Image(getClass().getResourceAsStream("/image/WhatsApp Image 2023-12-04 at 07.59.33_19c78ecd.jpg"));
            stickHeroCharacter.setImage(stickHeroImage);
        }
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Point2D getPosition() {
        return position;
    }

    public double getStick_length() {
        return stick_length;
    }

    public void setStick_length(double stick_length) {
        this.stick_length = stick_length;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void move(){
    }

}
