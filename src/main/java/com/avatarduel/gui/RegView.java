package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;

import javafx.geometry.Pos;

import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;


public class RegView{
    public static Pane Screen = new Pane();
    
    public static void loadRegScreen(AvatarDuel app){
        Screen.setMinSize(1400,925);
        Image back = new Image("com/wallpp.jpg");
        ImageView bg = new ImageView(back);
        Color c = Color.web("#69CDF8",1.0);
        bg.setFitWidth(1400);
        bg.setFitHeight(920);

        TextArea name1 = new TextArea("Player 1");
        name1.setMaxSize(150,15);
        name1.setStyle("-fx-alignment: bottom-center;");
        name1.setBackground(new Background(new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY)));
        TextArea name2 = new TextArea("Player 2");
        name2.setMaxSize(150,15);
        name2.setStyle("-fx-alignment: bottom-center;");
        name2.setBackground(new Background(new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY)));

        VBox space = new VBox();
        space.setMinSize(20,20);

        VBox names = new VBox();
        names.setAlignment(Pos.CENTER);        
        names.getChildren().add(name1);
        names.getChildren().add(space);
        names.getChildren().add(name2);

        Button start = new Button("Start!");
        start.setMinSize(80,50);
        start.setBackground(new Background(new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY)));
        // scr.getChildren().add(logo);
        
        VBox scr = new VBox();
        scr.setMinSize(450,600);
        scr.setAlignment(Pos.CENTER);
        scr.getChildren().add(names);
        VBox space2 = new VBox();
        space2.setMinSize(50,50);
        scr.getChildren().add(space2);
        scr.getChildren().add(start);

        BackgroundSize bSize = new BackgroundSize(1.0,1.0, true, true, false, false);

        BorderPane cek = new BorderPane();
        cek.setMinSize(1400,920);
        cek.setBackground(new Background(new BackgroundImage(back,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        bSize)));
        cek.setCenter(scr);


        Pane screen = new Pane();
        // screen.getChildren().add(bg);
        // screen.getChildren().add(scr);
        Screen.getChildren().add(cek);
        start.setOnAction( e->{
            Screen.getChildren().remove(screen);
            FieldG.gameView();
        }
        );
        // FieldG.gameView();
    }
}