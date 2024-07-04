package com.example.javafxtutorial;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public  class SaveData {
    public static Map<String, saveData.DataEntry> getMap() {
        return map;
    }

    static Map<String, saveData.DataEntry> map = new HashMap<>(4);

    private int num_cherries;
    private  static  int switcH=1;

    public static int getSwitcH() {
        return switcH;
    }

    public static void setSwitcH(int switcH) {
        SaveData.switcH = switcH;
    }

    private int playerScore;

    public int getNum_cherries() {
        return num_cherries;
    }

    public void setNum_cherries(int num_cherries) {
        this.num_cherries = num_cherries;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public class saveData {

        private static final String FILE_PATH = "src/main/java/com/example/javafxtutorial/Saveddata";


        // Using a Map to store game data
//        private static Map<String, DataEntry> gameDataMap = new HashMap<>();

        public static void saveData(String loadNumber, int numCherries, int playerScore) {
            if(getSwitcH()==1){
                setSwitcH(0);
                loadFromFile();
            }
            // Check if the DataEntry instance already exists
            DataEntry dataEntry = map.get(loadNumber);

            // If it doesn't exist, create a new instance
            if (dataEntry == null) {
                dataEntry = new DataEntry(playerScore, numCherries);
                // Put the DataEntry object in the HashMap
                map.put(loadNumber, dataEntry);
            } else {
                // Update the existing instance
                dataEntry.setScore(playerScore);
                dataEntry.setNumOfCherries(numCherries);

            }
            saveToFile();
        }

        public static void loadData() {
            // Load data from the file into the HashMap
            loadFromFile();
        }

        // Function to save game data to the file
        private static void saveToFile() {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
                for (Map.Entry<String, DataEntry> entry : map.entrySet()) {
                    writer.println(entry.getKey() + "," + entry.getValue().getScore() + "," + entry.getValue().getNumOfCherries());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Function to load game data from the file
//        private static void loadFromFile() {
//            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    String[] parts = line.split(",");
//                    if (parts.length == 3) {
//                        String loadNumber = parts[0];
//                        int score = Integer.parseInt(parts[1]);
//                        int numCherries = Integer.parseInt(parts[2]);
//                        System.out.println("Score"+score);
//                        System.out.println("Cherry"+numCherries);
//
//                        // Use the Flyweight pattern by checking if an instance already exists
//                        map.put(loadNumber, map.getOrDefault(loadNumber, new DataEntry(score, numCherries)));
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }




private static void loadFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            for(String str : parts){
                System.out.println(str);
            }

            // Trim each part to remove leading and trailing whitespaces
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
            }

            if (parts.length == 3) {
                String loadNumber = parts[0];
                int score = Integer.parseInt(parts[1]);
                int numCherries = Integer.parseInt(parts[2]);

                // Use the Flyweight pattern by checking if an instance already exists
                map.put(loadNumber, map.getOrDefault(loadNumber, new DataEntry(score, numCherries)));
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public static int[] getGameData(String loadNumber) {
            if(getSwitcH()==1){
                setSwitcH(0);
                loadFromFile();
            }
    DataEntry dataEntry = map.get(loadNumber);

    if (dataEntry != null) {
        System.out.println("hi");
        System.out.println(dataEntry.getNumOfCherries());
        System.out.println(dataEntry.getScore());
        // Entry exists, return its number of cherries and score
        return new int[]{dataEntry.getNumOfCherries(), dataEntry.getScore()};
    } else {
        // Entry does not exist, return default values (0 for number of cherries and score)
        return new int[]{0, 0};
    }
}


        // Inner class representing game data
        static class DataEntry {
            private int score;
            private int numOfCherries;

            public DataEntry(int score, int numOfCherries) {
                this.score = score;
                this.numOfCherries = numOfCherries;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public void setNumOfCherries(int numOfCherries) {
                this.numOfCherries = numOfCherries;
            }

            public int getScore() {
                return score;
            }

            public int getNumOfCherries() {
                return numOfCherries;
            }
        }



    }
}

