package com.example.javafxtutorial;

import javafx.application.Platform;

import java.util.ArrayList;

public class Game_controller implements  SoundManager{
    private  StichHeroCharacter stiickhero;
    private ArrayList<Pillar> pillars;
    private  ArrayList<Cherry> cherries;
    private String mode;

    private SaveData[]load;

    public String getMode() {return mode;}
    public void setMode(String mode) {this.mode = mode;}

    public StichHeroCharacter getStiickhero() {
        return stiickhero;
    }

    public void setStiickhero(StichHeroCharacter stiickhero) {
        this.stiickhero = stiickhero;
    }

    public ArrayList<Pillar> getPillars() {
        return pillars;
    }

    public void setPillars(ArrayList<Pillar> pillars) {
        this.pillars = pillars;
    }

    public ArrayList<Cherry> getCherries() {
        return cherries;
    }

    public void setCherries(ArrayList<Cherry> cherries) {
        this.cherries = cherries;
    }




    public void StartGame(){}
    public void restartLevel(){}
    public void LoadGame(){}
    public void saveGame(){}
    public void moveCharacter(){}

    public void extendStick(){}

    public void collectCherry(){
    }
    public void  revivePlayer(){}

    public  void endGame(){
    }

    public  void gameMode(){

    }


    @Override
    public void playSound() {

    }
}

