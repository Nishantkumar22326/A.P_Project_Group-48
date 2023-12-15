package com.example.javafxtutorial;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.example.javafxtutorial.SaveData.saveData.saveData;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class SaveddataTest {
    @Test
    public void testSaveData() {
            // Create a new instance of the DataEntry class
            SaveData.saveData.DataEntry dataEntry = new SaveData.saveData.DataEntry(100, 5);
            // Call the saveData method with the new instance
            saveData("loadNumber", dataEntry.getNumOfCherries(), dataEntry.getScore());
            // Retrieve the DataEntry object from the HashMap
            SaveData.saveData.DataEntry retrievedDataEntry = SaveData.map.get("loadNumber");
            // Check if the retrieved object has the correct score and number of cherries
            assertEquals(dataEntry.getScore(), retrievedDataEntry.getScore());
            assertEquals(dataEntry.getNumOfCherries(), retrievedDataEntry.getNumOfCherries());
        }


    @Test
    public void testGetGameData() {
        // Create a new instance of the DataEntry class
        SaveData.saveData.DataEntry dataEntry = new SaveData.saveData.DataEntry(100, 5);
        saveData("loadNumber", dataEntry.getNumOfCherries(), dataEntry.getScore());
        // Call the getGameData method with the loadNumber
        int[] result = SaveData.saveData.getGameData("loadNumber");
        // Check if the result is not null
        assertNotNull(result);
        // Check if the result has the correct number of cherries and score
        assertArrayEquals(new int[]{dataEntry.getNumOfCherries(), dataEntry.getScore()}, result);
    }






}


