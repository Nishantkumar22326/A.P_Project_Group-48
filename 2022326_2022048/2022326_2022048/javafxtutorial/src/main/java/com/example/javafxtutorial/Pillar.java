package com.example.javafxtutorial;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Pillar extends Basic_control {


    public static ArrayList<Double> getDoubleList() {
        return doubleList;
    }

    private static ArrayList<Double> doubleList = createRandomDoubleArrayList(37, 150);

//    // Print the ArrayList
//        System.out.println("Random Double ArrayList:");
//        for (Double value : doubleList) {
//        System.out.println(value);
//    }


    private static ArrayList<Double> createRandomDoubleArrayList(double minValue, double maxValue) {
        ArrayList<Double> doubleList = new ArrayList<>();
        Random random = new Random();

        for (double i = minValue; i <= maxValue; i++) {
            doubleList.add(i);
        }

        Collections.shuffle(doubleList, random);

        return doubleList;
    }
    private double width;
    private double height;




    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    @Override
    public void display(){

    }

}
