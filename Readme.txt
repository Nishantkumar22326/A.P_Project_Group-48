                                                              Advance programming Project Readme File
								         StickHero Game
								        Group Number-- 48
							
Team Member- 1. Akash Kumar(2022048) & 2. Nishant Kumar(2022326)

Github Link of Project---https://github.com/Nishantkumar22326/A.P_Project_Group-48.git

Design Pattern Used-
1. Singleton Design pattern in the Gamecontroller class.
2. Flyweight Design pattern in the saveData class

Working-->
1. Run the game through scenecontrol's class main function
2. Increase the size of stick by pressing and holding the increase button on the screen.
3. Tap on the screen for moving player up and down for collecting the cherries.
4. We have created four buttons for saving the game like the user can save the game in respective load and can load and start the game by clicking that load button in which the game wa saved.

Junit test--> Used for saveData class. The junit testcases of the saveData methods are made.

-> Testclass for Game Controller
-> A Temporary thread instance has been used to run the game
-> File method has been used to save and load game data(SavaData Class)
-> Commments added at neccessary places.

Assumption-->
1. Always exit the game through main menu always.


GameController class-->
This JavaFX Game Controller is a main part of the game and it serves as the central controller for managing game elements, sound effects, and interactions.
The controller is designed using the Singleton pattern to ensure a single instance throughout the game.

SceneController class-->
The scenesController class is a controller for managing different scenes in a JavaFX game.
It includes functionality for handling game mechanics, user input, and scene transitions. 
The controller manages the game's main scene, stick movement, pillar generation, sound effects, and scene transitions.

SaveData class-->
The SaveData class is designed to handle saving and loading game data in a JavaFX application.
It uses a Map to store game data for different load numbers, and the data is saved and loaded from a file. 
The class also includes an inner class DataEntry to represent game data.



Bonus (Extra part)--->
1. Added sound effects.
2. Some extra buttons for proper navigation throughout the game.




 

