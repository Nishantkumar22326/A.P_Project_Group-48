package com.example.javafxtutorial;

import javafx.application.Platform;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


// Game controller class
public class Game_controller implements  SoundManager {

    //using singleton design pattern
    static public int st =0;

    private static Game_controller gameController = new Game_controller();

    private Game_controller() {

    }

    public static Game_controller getInstance() {
        return gameController;
    }


    private StickHeroCharacter stiickhero;
    private ArrayList<Pillar> pillars;
    private ArrayList<Cherry> cherries;
    private String mode;

    SaveData saveData = new SaveData();

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public StickHeroCharacter getStiickhero() {
        return stiickhero;
    }

    public void setStiickhero(StickHeroCharacter stiickhero) {
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


    public void StartGame() {

    }

    public void restartLevel() {

    }

    public void LoadGame() {
    }

    public void saveGame() {
    }

    public void moveCharacter() {
    }

    public void extendStick() {
    }

    public void collectCherry() {
    }

    public void revivePlayer() {
    }

    public void endGame() {
    }

    public void gameMode() {

    }

    static volatile Clip clip;
    private static volatile Clip backgroundMusicClip;


    @Override
    public void playSound(String soundtype) {
        if("victory".equalsIgnoreCase(soundtype)){
            File file2 = new File("src/main/resources/Sound Effects/victory.wav");
            AudioInputStream audioInputStream2 = null;
            try {
                audioInputStream2 = AudioSystem.getAudioInputStream(file2);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            try {
                clip.open(audioInputStream2);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            clip.start();
        }
        else if("score".equalsIgnoreCase(soundtype)){
            File file_score = new File("src/main/resources/Sound Effects/score.wav");
            AudioInputStream audioInputStream_score = null;
            try {
                audioInputStream_score = AudioSystem.getAudioInputStream(file_score);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            try {
                clip.open(audioInputStream_score);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            clip.start();
        }
        else if("stickrotate".equalsIgnoreCase(soundtype)){
            File file = new File("src/main/resources/Sound Effects/stick_fallen.wav");
            AudioInputStream audioInputStream = null;
            try {
                audioInputStream = AudioSystem.getAudioInputStream(file);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            try {
                clip.open(audioInputStream);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            clip.start();
        }
        else if("backgroundmusic".equalsIgnoreCase(soundtype)){

            if (backgroundMusicClip == null) {
                try {
                    File file = new File("src/main/resources/Sound Effects/Background music.wav");
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                    backgroundMusicClip = AudioSystem.getClip();
                    backgroundMusicClip.open(audioInputStream);

                    // Set the volume only when the clip is initialized
                    FloatControl gainControl = (FloatControl) backgroundMusicClip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-40.0f);
                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
            }

            if (!backgroundMusicClip.isRunning()) {
                backgroundMusicClip.setMicrosecondPosition(0);
                backgroundMusicClip.start();
            }
        }

        else if("increasestick".equalsIgnoreCase(soundtype)){
            File file = new File("src/main/resources/Sound Effects/stick-grow-loop2.wav");
            AudioInputStream audioInputStream = null;
            try {
                audioInputStream = AudioSystem.getAudioInputStream(file);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            try {
                clip.open(audioInputStream);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            clip.start();
        }

        else if ("herofalls".equalsIgnoreCase(soundtype)){
            File file3 = new File("src/main/resources/Sound Effects/Death sound.wav");
            AudioInputStream audioInputStream3 = null;
            try {
                audioInputStream3 = AudioSystem.getAudioInputStream(file3);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            try {
                clip.open(audioInputStream3);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            clip.start();
        }
        else{
            System.out.println("No sound left");
        }

    }
}



