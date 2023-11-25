package com.example.javafxtutorial;

public class StichHeroCharacter implements Movable {
    private Point2D position ;
    private double stick_length;
    private  int score;

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