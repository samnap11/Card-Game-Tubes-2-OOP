# Avatar Card Game

## Description

A simple game card based on the Avatar universe, using javafx for the interface, and wrapped by gradle.

## Code structure
```
root
└── src/main
    └── java/com/avatarduel
        ├── card
        │   ├── Aura.java
        │   ├── Card.java
        │   ├── CardLoader.java
        │   ├── Character.java
        │   ├── Destroy.java
        │   ├── Element.java
        │   ├── HasCost.java
        │   ├── Land.java
        │   ├── PowerUp.java
        │   └── Skill.java
        ├── controller
        │   ├── FieldController.java
        │   └── HandController.java
        ├── deck
        │   └── Deck.java
        ├── gui
        │   ├── Buttons.java
        │   ├── CardView.java
        │   ├── FieldSide.java
        │   ├── FieldView.java
        │   ├── HandView.java
        │   ├── HealthView.java
        │   ├── MainView.java
        │   └── RegView.java
        ├── player
        │   └── Player.jav
        ├── state
        │   ├── State.java
        │   └── Phase.java
        ├── util
        │   └── CSVReader.java
        └── AvatarDuel.java

```
## Screenshots
![Register Screen](images/Main.jpg)
![Gameplay Screen](images/Play.jpg)



## How to build the game
To build the game, simply type this in the terminal (for Linux users) or command prompt (for Windows users)

**For Linux users**
>./gradlew build

**For Windows users**
>gradlew build

## How to run the game
To run the game, simply type this in the terminal (for Linux users) or command prompt (for Windows users)

**For Linux users**
>./gradlew run

**For Windows users**
>gradlew run

## How to get the documentation for the source code
Simply type this in the terminal (for Linux users) or command prompt (for Windows users)

**For Linux users**
>./gradlew avatarDocs

**For Windows users**
>gradlew avatarDocs

After that, you can find the documentation in **build/docs/javadoc/index.html**.
After you open it in your browser, you can go to the documentation of any packages or classes which are listed there.