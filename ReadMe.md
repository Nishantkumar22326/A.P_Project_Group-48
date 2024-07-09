# Stick Hero Game

Welcome to the Stick Hero Application! This is a simple JavaFX game where the player controls a character by extending a stick to cross platforms. The goal is to reach the next platform without falling.

**Team Members:**
1. Akash Kumar (2022048)
2. Nishant Kumar (2022326)
   

## Table of Contents
- [Design Patterns Used](#design-patterns-used)
- [Working](#working)
- [JUnit Tests](#junit-tests)
- [Assumptions](#assumptions)
- [Class Descriptions](#class-descriptions)
  - [GameController](#gamecontroller-class)
  - [SceneController](#scenecontroller-class)
  - [SaveData](#savedata-class)
- [Bonus Features](#bonus-features)
- [Stick Hero Application](#stick-hero-application)
  - [Features](#features)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Run the Application](#run-the-application)
    - [Game Controls](#game-controls)
  - [Structure of the Project](#structure-of-the-project)
    - [Packages and Classes](#packages-and-classes)
    - [Resources](#resources)
  - [How to Play](#how-to-play)
  - [Additional Notes](#additional-notes)
  - [Images](#images)
  - [Class Explanations](#class-explanations)
    - [Controller Class](#controller-class)
      - [Game State and Parameters](#game-state-and-parameters)
    - [Pillars Class](#pillars-class)

## Design Patterns Used
1. **Singleton Design Pattern:** Used in the `GameController` class to ensure only one instance of the game controller.
2. **Flyweight Design Pattern:** Used in the `SaveData` class to efficiently manage game data storage.

## Working
1. Run the game through the `SceneController` class's main function.
2. Increase the size of the stick by pressing and holding the increase button on the screen.
3. Tap on the screen to move the player up and down to collect the cherries.
4. Four buttons are available to save the game. The user can save the game in respective slots and can load and start the game by clicking the load button where the game was saved.

## JUnit Tests
- **SaveData Class:** Includes JUnit test cases for the methods in the `SaveData` class.
- **GameController Test Class:** A test class for the `GameController` class.
- A temporary thread instance is used to run the game.
- File methods are used to save and load game data (`SaveData` class).
- Comments are added at necessary places.

## Assumptions
- Always exit the game through the main menu.

## Class Descriptions

### GameController Class
The `GameController` class is the main part of the game and serves as the central controller for managing game elements, sound effects, and interactions. It is designed using the Singleton pattern to ensure a single instance throughout the game.

### SceneController Class
The `SceneController` class manages different scenes in a JavaFX game. It includes functionality for handling game mechanics, user input, and scene transitions. The controller manages the game's main scene, stick movement, pillar generation, sound effects, and scene transitions.

### SaveData Class
The `SaveData` class is designed to save and load game data in a JavaFX application. It uses a `Map` to store game data for different load numbers, and the data is saved and loaded from a file. The class also includes an inner class, `DataEntry`, representing game data.

## Bonus Features
1. Added sound effects.
2. Extra buttons for proper navigation throughout the game.

---

# Stick Hero Application

Welcome to the Stick Hero Application! This is a simple JavaFX game where the player controls a character by extending a stick to cross platforms. The goal is to reach the next platform without falling.

## Features
- **Gameplay:** Extend the stick by clicking and holding the increase button, and release to drop the stick.
- **Scoring:** Score points for successfully reaching the next platform and collect cherries for reviving.
- **Sound Effects:** Enjoy sound effects for various actions in the game.
- **Exit Confirmation:** A confirmation dialog is provided when attempting to exit the game.

## Getting Started

### Prerequisites
- Ensure you have Java installed on your machine.

### Run the Application
- Execute the `StickHeroApplication` class to start the game.

### Game Controls
- Click and hold the mouse to extend the stick.
- Release the mouse to drop the stick and move the character.

## Structure of the Project

### Packages and Classes
- `com.example.stickheroapplication`: Main package containing the application code.
  - **StickHeroApplication:** Main class to launch the application.
  - **Controller:** Controller class for the gameplay screen.
  - **Diamond:** Class representing a collectible diamond in the game.
  - **Pillars:** Class handling the generation of platforms in the game.
  - **SaveGame:** Class representing a saved game state.
  - **SceneController:** Controller class for the home screen.

### Resources
- `images`: A folder containing image resources is used in the application.

## How to Play
1. Launch the game.
2. Click and hold the mouse to extend the stick.
3. Release the mouse to drop the stick and move the character.
4. Reach the next platform to score points.

## Additional Notes
- This project uses JavaFX for the graphical user interface.
- Sound effects are incorporated to enhance the gaming experience.
- The game features a confirmation dialog when attempting to exit.

## Images

| Start      | Retry        |
|------------|--------------|
| ![Start Page](https://github.com/Nishantkumar22326/A.P_Project_Group-48/blob/main/Images/1.jpg) | ![Retry Page](https://github.com/Nishantkumar22326/A.P_Project_Group-48/blob/main/Images/4.jpg) |

| Character  | Stick Increase |
|------------|----------------|
| ![Character](https://github.com/Nishantkumar22326/A.P_Project_Group-48/blob/main/Images/2.jpg) | ![Stick Increase](https://github.com/Nishantkumar22326/A.P_Project_Group-48/blob/main/Images/3.jpg) |

| Menu       | Load Game     |
|------------|----------------|
| ![Menu](https://github.com/Nishantkumar22326/A.P_Project_Group-48/blob/main/Images/5.jpg) | ![Load Game](https://github.com/Nishantkumar22326/A.P_Project_Group-48/blob/main/Images/6.jpg) |

#### Key Features of the First Iteration
- **Basic Stick Extension Mechanism:** Players could click and hold the mouse button to extend the stick and release it to let the character walk across.
- **Simple Scoring System:** Points were awarded based on the accuracy of the stick length concerning the next platform.
- **Minimalist Graphics:** The game featured simple graphics to keep the focus on the gameplay.

This iteration laid the groundwork for subsequent updates, introducing additional features such as sound effects, scoring enhancements, and improved graphics.

## Class Explanations

### Controller Class
The `Controller` class is a crucial component in the Stick Hero Application. It serves as the controller for the gameplay screen, managing the game logic, user interactions, and transitions between different game states. Key aspects of the `Controller` class include:
- **gameScreen:** A `Pane` representing the main game screen where platforms and characters are displayed.
- **score:** A `Label` displaying the current score of the player.
- **stickHero:** An `ImageView` representing the character in the game.

#### Game State and Parameters
- **endGame():** Method to handle the end of the game, triggering the character's fall and displaying the game-over message.
- **displayGameOverMessage():** Method to display the game over the message with a fade transition.
- **switchToMainScreen():** Method to transition to the main screen after the game ends.

### Pillars Class
The `Pillars` class in the Stick Hero Application is responsible for generating and handling the properties of the platforms (pillars) in the game. Key aspects of the `Pillars` class include:
- **Extends Rectangle:** The `Pillars` class extends the `Rectangle` class, indicating that it inherits properties and methods from `Rectangle`. This allows `Pillars` to be visually represented as rectangles.
- **random:** An instance of the `Random` class for generating random values.
- **screenWidth:** The width of the game screen.
- **PLATFORM_HEIGHT:** The constant height of the platforms.
- **minWidth** and **maxWidth:** The minimum and maximum width of the platforms.
- **layoutY:** The y-coordinate at which the platforms are placed.
- **minLayoutX** and **maxLayoutX:** The minimum and maximum x-coordinates for placing the platforms.

---

Enjoy playing Stick Hero! If you encounter any issues or have any questions, feel free to reach out for support. Happy gaming!
