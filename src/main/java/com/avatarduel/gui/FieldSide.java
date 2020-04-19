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

/**
 * FieldSide is responsible for holding the instance of Lands and Decks of each player
 * 
 * @author saya
 */
public class FieldSide{

    public static VBox land1 = new VBox();

    public static VBox land2 = new VBox();

    public static HBox deckP1 = new HBox();

    public static HBox deckP2 = new HBox();

    /**
     * instanciate the deck gui
     * @param P Owner of deck
     * @return The box containing the deck
     */
    public static HBox uiDeck(Player P){ //tinggal ditambahi parameter deck
        BorderPane main = new BorderPane();
        HBox deckP = P == State.p1 ? deckP1 : deckP2;
        HBox deckUI = new HBox();
        deckUI.setMaxHeight(100*1.618);
        deckUI.setMinWidth(100);
        deckUI.setAlignment(Pos.CENTER);
        deckUI.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        // HBox deckP = new HBox();
        String str = String.format("%d/%d", P.getDeck().getSize() ,P.getDeck().kap);
        Text hp = new Text(str);
        hp.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        deckP.setAlignment(Pos.CENTER);
        deckP.getChildren().clear();
        deckP.getChildren().add(hp);
        main.setBottom(deckP);
        deckUI.getChildren().add(main);
        main.setCenter(Card.closedCard(100));
        return deckUI;
    }

    /**
     * Update the numbers of deck card left viewed
     * @param p owner of deck
     */
    public static void updateDeckSize(Player p){
        HBox deckP = p == State.p1 ? deckP1 : deckP2;
        deckP.getChildren().clear();
        String str = String.format("%d/%d", p.getDeck().getSize() ,p.getDeck().kap);
        Text hp = new Text(str);
        hp.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        deckP.getChildren().add(hp);
    }

    /**
     * Initiate ui for land of both players
     * 
     */
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

    /**
     * Update lands when cards are used, or they are refreshed on turn starts
     * @param p Land owner
     */
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