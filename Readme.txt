
                                                           Advanced programming Project Readme File
								         StickHero Game
								        Group Number-- 48

Team Member- 1. Akash Kumar(2022048) & 2. Nishant Kumar(2022326)

Github Link of Project---https://github.com/Nishantkumar22326/A.P_Project_Group-48.git

Design Pattern Used-
1. Singleton Design pattern in the Gamecontroller class.
2. Flyweight Design pattern in the saveData class

Working-->
1. Run the game through scene control's class-main function
2. Increase the size of the stick by pressing and holding the increase button on the screen.
3. Tap on the screen to move the player up and down to collect the cherries.
4. We have created four buttons to save the game. The user can save the game in respective loads and can load and start the game by clicking the load button on which the game was saved.

Junit test--> Used for saveData class. The JUnit test cases of the saveData methods are made.

-> Testclass for Game Controller
-> A Temporary thread instance has been used to run the game
-> File method has been used to save and load game data(SavaData Class)
-> Comments added at necessary places.

Assumption-->
1. Always exit the game through the main menu.


GameController class-->
This JavaFX Game Controller is a main part of the game, and it serves as the central controller for managing game elements, sound effects, and interactions.
The controller is designed using the Singleton pattern to ensure a single instance throughout the game.

SceneController class-->
The scenesController class is a controller for managing different scenes in a JavaFX game.
It includes functionality for handling game mechanics, user input, and scene transitions. 
The controller manages the game's main scene, stick movement, pillar generation, sound effects, and scene transitions.

SaveData class-->
The SaveData class is designed to save and load game data in a JavaFX application.
It uses a Map to store game data for different load numbers, and the data is saved and loaded from a file. 
The class also includes an inner class, DataEntry, representing game data.



Bonus (Extra part)--->
1. Added sound effects.
2. Some extra buttons for proper navigation throughout the game.




 

