package com.avatarduel.gui;

import com.avatarduel.*;

import javafx.geometry.Pos;

import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class RegView{
    public static Pane Screen = new Pane();
    
    public static void loadRegScreen(AvatarDuel app){
        Screen.setMinSize(1400,900);
        Image back = new Image("com/bae.jpg");
        ImageView bg = new ImageView(back);
        bg.setFitWidth(450);
        bg.setFitHeight(600);

        TextArea name1 = new TextArea("Player 1");
        name1.setMaxSize(150,18);
        TextArea name2 = new TextArea("Player 2");
        name2.setMaxSize(150,18);

        VBox space = new VBox();
        space.setMinSize(20,20);

        VBox names = new VBox();
        names.setAlignment(Pos.CENTER);        
        names.getChildren().add(name1);
        names.getChildren().add(space);
        names.getChildren().add(name2);

        Button start = new Button("Start!");
        start.setMinSize(80,50);
        // scr.getChildren().add(logo);
        
        VBox scr = new VBox();
        scr.setMinSize(450,600);
        scr.setAlignment(Pos.CENTER);
        scr.getChildren().add(names);
        VBox space2 = new VBox();
        space2.setMinSize(50,50);
        scr.getChildren().add(space2);
        scr.getChildren().add(start);

        Pane screen = new Pane();
        screen.getChildren().add(bg);
        screen.getChildren().add(scr);
        Screen.getChildren().add(screen);
        start.setOnAction( e->{
            Screen.getChildren().remove(screen);
            FieldG.gameView();
        }
        );
        // FieldG.gameView();
    }
}