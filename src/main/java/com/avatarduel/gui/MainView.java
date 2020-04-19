package com.avatarduel.gui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight;
import javafx.scene.paint.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.avatarduel.card.Card;
import com.avatarduel.card.Element;
import com.avatarduel.card.Character;
import com.avatarduel.player.Player;
import com.avatarduel.state.State;
import com.avatarduel.deck.Deck;
import com.avatarduel.gui.Buttons;
import com.avatarduel.gui.HandView;
import com.avatarduel.controller.*;

public class MainView{
    public static void gameView(){//fungsi ini panjang karena menginisiasi segalanya, jadi menurut saya tidak apa apa panjang
        Image back = new Image("com/wallppg.jpg");
        ImageView bg = new ImageView(back);
        BackgroundSize bSize = new BackgroundSize(1.0,1.0, true, true, false, false);

        HBox store = new HBox();
        store.setMinHeight(440);
        store.setAlignment(Pos.CENTER);
        CardOnDisplay.cardDisp.getChildren().add(Card.drawCard(Card.getSuzy(),230));
        store.getChildren().add(CardOnDisplay.cardDisp);

        BorderPane cardLayout2 = new BorderPane();
        cardLayout2.setMinWidth(250);
        cardLayout2.setMaxHeight(400);
        cardLayout2.setBorder(new Border(new BorderStroke(Color.WHITE,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));

        HBox store2 = new HBox();
        store2.setMinHeight(440);
        store2.setAlignment(Pos.CENTER);
        store2.getChildren().add(cardLayout2);
        
        FieldSide.initLandUI();
        // Left Layout
        //land layout
        BorderPane landp1 = new BorderPane();
        landp1.setCenter(FieldSide.land1);
        BorderPane landp2 = new BorderPane ();
        landp2.setCenter(FieldSide.land2);
        VBox landLayout = new VBox();
        HBox padLand = new HBox();
        padLand.setMinHeight(30);
        landLayout.setAlignment(Pos.CENTER);
        landLayout.getChildren().add(landp2);
        landLayout.getChildren().add(padLand);
        landLayout.getChildren().add(landp1);

        //lef layout in main
        BorderPane sidebar = new BorderPane();
        sidebar.setMinWidth(290);
        sidebar.setMinHeight(880);
        sidebar.setTop(store);
        sidebar.setBottom(store2);

        BorderPane bigger = new BorderPane();

        // Right Layout
        BorderPane plane = new BorderPane();
        plane.setMinWidth(900);
        plane.setMaxHeight(840);
        plane.setTop(FieldView.generateField(State.p2));
        BorderPane atas = new BorderPane();
        HBox spaces = new HBox();
        spaces.setMinHeight(100);
        spaces.setMaxWidth(750);
        spaces.setBorder(new Border(new BorderStroke(Color.WHITE,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
        spaces.getChildren().add(HandView.p2Hand);
        atas.setBottom(spaces);
        atas.setTop(HealthView.hpBar(State.p2,HealthView.healthp2));

        //bar
        BorderPane bawah = new BorderPane();
        HBox spaces2 = new HBox();
        spaces2.setMinHeight(100);
        spaces2.setMaxWidth(750);
        spaces2.setBorder(new Border(new BorderStroke(Color.WHITE,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
        spaces2.getChildren().add(HandView.p1Hand);
        bawah.setTop(spaces2);
        bawah.setBottom(HealthView.hpBar(State.p1,HealthView.healthp1));
        plane.setBottom(FieldView.generateField(State.p1));
        bigger.setCenter(plane);
        Buttons.init();
        bigger.setRight(Buttons.phaseButtons());
        bigger.setTop(atas);
        bigger.setBottom(bawah);

        HandView.init();

        BorderPane layoutBigger = new BorderPane();
        layoutBigger.setCenter(bigger);
        layoutBigger.setLeft(landLayout);

        HBox planeBox = new HBox();
        planeBox.setMinWidth(1000);
        planeBox.setAlignment(Pos.CENTER);
        planeBox.getChildren().add(layoutBigger);

        //grid bar
        // Main Layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setBackground(new Background(new BackgroundImage(back,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        bSize)));
        mainLayout.setLeft(sidebar);
        mainLayout.setCenter(planeBox);
        RegView.Screen.getChildren().clear();
        RegView.Screen.getChildren().add(mainLayout);
    }
}