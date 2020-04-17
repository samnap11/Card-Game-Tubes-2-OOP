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
import com.avatarduel.card.Card;
import com.avatarduel.card.Element;
import com.avatarduel.card.Character;
import com.avatarduel.player.Player;
import com.avatarduel.state.State;
import com.avatarduel.deck.Deck;
import com.avatarduel.gui.Buttons;

import java.util.*;


public class FieldG{
    public static List<HBox> boxes = new ArrayList<>(); //0-11 player 2, 12-23 player 1


    public static void gameView(){
        HBox store = new HBox();
        store.setMinHeight(440);
        store.setAlignment(Pos.CENTER);
        // HBox bigCard = new HBox();
        // bigCard.setMinHeight(320);
        // bigCard.setMaxHeight(320);
        // bigCard.setMinWidth(200);
        // bigCard.setMaxWidth(200);        
        // bigCard.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        HBox card = new HBox();
        card.setMaxWidth(200);
        card.setMinWidth(200);
        card.setAlignment(Pos.CENTER);
        card.getChildren().add(Card.drawCard(Card.getSuzy(),200));
        store.getChildren().add(card);
        card.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));   

        BorderPane cardLayout2 = new BorderPane();
        cardLayout2.setMinWidth(250);
        cardLayout2.setMaxHeight(400);
        cardLayout2.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));

        HBox store2 = new HBox();
        store2.setMinHeight(440);
        store2.setAlignment(Pos.CENTER);
        store2.getChildren().add(cardLayout2);
        

        // Left Layout
        //land layout
        BorderPane landp1 = new BorderPane();
        // landp1.setBottom(FieldG.uiLand());
        landp1.setCenter(FieldG.uiLand(State.p2));
        BorderPane landp2 = new BorderPane ();
        // landp2.setBottom(FieldG.uiLand());
        landp2.setCenter(FieldG.uiLand(State.p1));
        // BorderPane landonfield = new BorderPane();
        // landonfield.setBottom(landp2);
        // landonfield.setTop(landp1);
        VBox landLayout = new VBox();
        HBox padLand = new HBox();
        padLand.setMinHeight(30);
        landLayout.setAlignment(Pos.CENTER);
        landLayout.getChildren().add(landp1);
        landLayout.getChildren().add(padLand);
        landLayout.getChildren().add(landp2);
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
        plane.setTop(FieldG.generateField(State.p2));
        // plane.setCenter(ButtonView.getPhaseButtons());
        BorderPane atas = new BorderPane();
        HBox spaces = new HBox();
        spaces.setMinHeight(100);
        spaces.setMaxWidth(750);
        spaces.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        atas.setBottom(spaces);
        atas.setTop(FieldG.hpBar(State.p2));
        //bar
        // BorderPane barBawah = new BorderPane();
        // Player pe = new Player();
        // barBawah.setBottom(FieldG.hpBar(State.p1));
        BorderPane bawah = new BorderPane();
        HBox spaces2 = new HBox();
        spaces2.setMinHeight(100);
        spaces2.setMaxWidth(750);
        spaces2.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        bawah.setTop(spaces2);
        bawah.setBottom(FieldG.hpBar(State.p1));
        // spaces2.getChildren().add(barBawah);
        // plane.setCenter(spaces);  
        // plane.setRight(spaces); 
        plane.setBottom(FieldG.generateField(State.p1)); //generateField cuma bikin field kartu, harusnya sekalian health bar ama hand card, mungkin namanya jadi generatePlayerView()
        // plane.setRight(phaseButtons());
        bigger.setCenter(plane);
        Buttons.init();
        bigger.setRight(Buttons.phaseButtons());
        bigger.setTop(atas);
        bigger.setBottom(bawah);

        BorderPane layoutBigger = new BorderPane();
        layoutBigger.setCenter(bigger);
        layoutBigger.setLeft(landLayout);

        HBox planeBox = new HBox();
        planeBox.setMinWidth(1000);
        planeBox.setAlignment(Pos.CENTER);
        planeBox.getChildren().add(layoutBigger);

        // Another init after design is loaded
        // FieldView.initFieldBoxes();
        //grid bar
        // Main Layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setLeft(sidebar);
        mainLayout.setCenter(planeBox);

        RegView.Screen.getChildren().add(mainLayout);
    }

    public static HBox generateField(Player p){
        VBox fieldInside = new VBox();
        fieldInside.setAlignment(Pos.CENTER);
        fieldInside.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        fieldInside.getChildren().add(genBoxField(6,100, 10));
        HBox spaces = new HBox();
        spaces.setMinSize(10,10);
        fieldInside.getChildren().add(spaces);
        fieldInside.getChildren().add(genBoxField(6,100, 10));
        HBox field = new HBox();
        field.setMinWidth(800);
        field.setMinHeight(225);
        field.setAlignment(Pos.CENTER);
        field.getChildren().add(fieldInside);
        BorderPane gridDeck = new BorderPane();
        gridDeck.setCenter(FieldG.uiDeck(p.pDeck));
        field.getChildren().add(gridDeck);

        return field;
    }

    public static HBox genBoxField(int counts, double size, double pad) { //ditambahi parameter deck buat bedain buat player 1 ata player 2
        // List<HBox> boxes = new ArrayList<>();
        HBox boxField = new HBox();
        double height = size*1.618;
        boxField.setMinWidth((size+pad)*counts+pad);
        boxField.setAlignment(Pos.CENTER);
        for (int i=0; i<counts; i++) {
            HBox b = new HBox();
            b.setMinSize(size,height);
            b.setAlignment(Pos.CENTER);
            b.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
            boxes.add(b);
            boxField.getChildren().add(boxes.get(boxes.size()-1));
                HBox spaces = new HBox();
                spaces.setMinSize(10,10);
            boxField.getChildren().add(spaces);
        }
        return boxField;
    }
    public static BorderPane hpBar(Player pe){
        int maxHp = 80;
        double curHP;
        BorderPane barPane = new BorderPane();
        ProgressBar barHp = new ProgressBar();
        curHP = (double)pe.getHp()/maxHp;
        barHp.setProgress(curHP);
        barHp.setMinWidth(700);
        barHp.setMinHeight(10);
        barPane.setCenter(barHp);
        Text hp = new Text("HP");
        hp.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Text valHP = new Text(String.valueOf(pe.getHp()));
        valHP.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        barPane.setLeft(hp);
        barPane.setRight(valHP);
        return barPane;
    }
    public static HBox uiDeck(Deck D){ //tinggal ditambahi parameter deck
        BorderPane main = new BorderPane();
        // main.getChildren().add(Card.closedCard(100));
        HBox deckUI = new HBox();
        deckUI.setMaxHeight(100*1.618);
        deckUI.setMinWidth(100);
        deckUI.setAlignment(Pos.CENTER);
        deckUI.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        BorderPane uiDck = new BorderPane();
        String str = String.format("%d/%d", D.getSize() ,D.kap);
        Text hp = new Text(str);
        hp.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        uiDck.setCenter(hp);
        main.setBottom(uiDck);
        deckUI.getChildren().add(main);
        main.setCenter(Card.closedCard(100));
        // main.setAlignment(Pos.CENTER);
        // main.setAlignment(Pos.CENTER);
        return deckUI;
        
    }
    public static VBox uiLand(Player p){ //tinggal ditambahin parameter land mungkin
        VBox landUI = new VBox();
        landUI.setMinHeight(100*1.618);
        landUI.setMinWidth(100);
        landUI.setAlignment(Pos.CENTER);
        landUI.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        BorderPane uiland = new BorderPane();
        // String air = String.format("%d/%d");
        // String str = String.format("Ini Land");
        // String str = String.format("Ini Land");
        // String str = String.format("Ini Land");
        Text air = new Text("AIR " + p.getLand(Element.AIR));
        Text water = new Text("WATER " +p.getLand(Element.WATER));
        Text fire = new Text("FIRE " +p.getLand(Element.FIRE));
        Text earth = new Text("EARTH " +p.getLand(Element.EARTH));
        // land.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        // uiland.setCenter(land);
        landUI.getChildren().add(air);
        landUI.getChildren().add(water);
        landUI.getChildren().add(fire);
        landUI.getChildren().add(earth);
        return landUI;

    }
    

}