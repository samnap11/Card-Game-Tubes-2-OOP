package com.avatarduel.gui;


import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

import com.avatarduel.model.Card;
import com.avatarduel.model.Element;
import com.avatarduel.model.Character;

import java.util.*;


public class FieldG{
    public static List<HBox> boxes = new ArrayList<>();

    private static Button drawPhaseButton = new Button("Draw");
    private static Button main1PhaseButton = new Button("Main 1");
    private static Button battlePhaseButton = new Button("Battle");
    private static Button main2PhaseButton = new Button("Main 2");
    private static Button endPhaseButton = new Button("End");


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
        plane.setTop(FieldG.generateField());
        // plane.setCenter(ButtonView.getPhaseButtons());
        HBox spaces = new HBox();
        spaces.setMinSize(50,50);
        spaces.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        HBox spaces2 = new HBox();
        spaces2.setMinSize(50,50);
        spaces2.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        // plane.setCenter(spaces);  
        // plane.setRight(spaces);  
        plane.setBottom(FieldG.generateField()); //generateField cuma bikin field kartu, harusnya sekalian health bar ama hand card, mungkin namanya jadi generatePlayerView()
        // plane.setRight(phaseButtons());
        bigger.setCenter(plane);
        bigger.setRight(phaseButtons());
        bigger.setTop(spaces);
        bigger.setBottom(spaces2);

        HBox planeBox = new HBox();
        planeBox.setMinWidth(1000);
        planeBox.setAlignment(Pos.CENTER);
        planeBox.getChildren().add(bigger);

        // Another init after design is loaded
        // FieldView.initFieldBoxes();

        // Main Layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setLeft(sidebar);
        mainLayout.setCenter(planeBox);

        RegView.Screen.getChildren().add(mainLayout);
    }

    public static HBox generateField(){
        VBox fieldInside = new VBox();
        fieldInside.setAlignment(Pos.CENTER);
        fieldInside.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        fieldInside.getChildren().add(genBoxField(8,110, 10));
        HBox spaces = new HBox();
        spaces.setMinSize(10,10);
        fieldInside.getChildren().add(spaces);
        fieldInside.getChildren().add(genBoxField(8,110, 10));

        HBox field = new HBox();
        field.setMinWidth(800);
        field.setMinHeight(225);
        field.setAlignment(Pos.CENTER);
        field.getChildren().add(fieldInside);
        // field.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(4))));

        return field;
    }

    public static HBox genBoxField(int counts, double size, double pad) {
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

    public static VBox phaseButtons(){
        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(drawPhaseButton);
        buttonBox.getChildren().add(main1PhaseButton);
        buttonBox.getChildren().add(battlePhaseButton);
        buttonBox.getChildren().add(main2PhaseButton);
        buttonBox.getChildren().add(endPhaseButton);
        return buttonBox;
    }

}