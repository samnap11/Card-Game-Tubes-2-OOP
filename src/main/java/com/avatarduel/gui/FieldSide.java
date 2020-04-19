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

public class FieldSide{
    public static VBox land1 = new VBox();

    public static VBox land2 = new VBox();

    public static HBox uiDck1 = new HBox();

    public static HBox uiDck2 = new HBox();

    
    public static HBox uiDeck(Player P){ //tinggal ditambahi parameter deck
        BorderPane main = new BorderPane();
        HBox uiDck = P == State.p1 ? uiDck1 : uiDck2;
        HBox deckUI = new HBox();
        deckUI.setMaxHeight(100*1.618);
        deckUI.setMinWidth(100);
        deckUI.setAlignment(Pos.CENTER);
        deckUI.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        // HBox uiDck = new HBox();
        String str = String.format("%d/%d", P.pDeck.getSize() ,P.pDeck.kap);
        Text hp = new Text(str);
        hp.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        uiDck.setAlignment(Pos.CENTER);
        uiDck.getChildren().clear();
        uiDck.getChildren().add(hp);
        main.setBottom(uiDck);
        deckUI.getChildren().add(main);
        main.setCenter(Card.closedCard(100));
        return deckUI;
    }

    public static void updateDeckSize(Player p){
        HBox uiDck = p == State.p1 ? uiDck1 : uiDck2;
        uiDck.getChildren().clear();
        String str = String.format("%d/%d", p.pDeck.getSize() ,p.pDeck.kap);
        Text hp = new Text(str);
        hp.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        uiDck.getChildren().add(hp);
    }

    public static void initLandUI(){
        land1.setMinHeight(100*1.618);
        land1.setMinWidth(100);
        land1.setAlignment(Pos.CENTER);
        land1.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        updateLand(State.p1);
        
        land2.setMinHeight(100*1.618);
        land2.setMinWidth(100);
        land2.setAlignment(Pos.CENTER);
        land2.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        updateLand(State.p2);

    }

    public static void updateLand(Player p){ //tinggal ditambahin parameter land mungkin
        Text air = new Text("AIR " + p.getLand(Element.AIR));
        Text water = new Text("WATER " +p.getLand(Element.WATER));
        Text fire = new Text("FIRE " +p.getLand(Element.FIRE));
        Text earth = new Text("EARTH " +p.getLand(Element.EARTH));
        Text energy = new Text("ENERGY " +p.getLand(Element.ENERGY));

        VBox land = p == State.p1 ? land1 : land2;
     
        land.getChildren().clear();
        land.getChildren().add(air);
        land.getChildren().add(water);
        land.getChildren().add(fire);
        land.getChildren().add(earth);
        land.getChildren().add(energy);
    }
}