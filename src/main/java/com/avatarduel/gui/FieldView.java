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

import java.util.*;

/**
 * FieldView holds the list of field boxes, and is responsible for visualizing them to players.
 *
 * @author saya
 */
public class FieldView{
    /**
     * Ze list that contains all the box on the field, 
     * for modification and update purposes the instances must be kept,
     * Thus it is kept in a list.
     */
    public static List<HBox> boxes = new ArrayList<>(); //0-11 player 2, 12-23 player 1 (box box representasi field)

    /**
     * Generate and instanciate the field of which is owned by a player
     * @param p Player who will own the field
     * @return VBox containing the field
     */
    public static HBox generateField(Player p){
        VBox fieldInside = new VBox();
        HBox spaces = new HBox();
        spaces.setMinSize(5,5);
        fieldInside.setAlignment(Pos.CENTER);
        fieldInside.setBorder(new Border(new BorderStroke(Color.WHITE,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
        fieldInside.getChildren().add(spaces);
        fieldInside.getChildren().add(genBoxField(6,100,p));
        spaces = new HBox();
        spaces.setMinSize(5,5);
        fieldInside.getChildren().add(spaces);
        fieldInside.getChildren().add(genBoxField(6,100,p));
        spaces = new HBox();
        spaces.setMinSize(5,5);
        fieldInside.getChildren().add(spaces);
        HBox field = new HBox();
        field.setMinWidth(800);
        field.setMinHeight(225);
        field.setAlignment(Pos.CENTER);
        field.getChildren().add(fieldInside);
        BorderPane gridDeck = new BorderPane();
        gridDeck.setCenter(FieldSide.uiDeck(p));
        field.getChildren().add(gridDeck);

        return field;
    }

    /**
     * Generate field boxes and add them to the list with the specified specs
     * @param p Player who will own the field
     * @param counts Number of box in the field
     * @param size Width of box
     * @return HBox containing the field boxes for 1 line of the field
     */
    public static HBox genBoxField(int counts, double size,Player p) { //ditambahi parameter deck buat bedain buat player 1 ata player 2
        // List<HBox> boxes = new ArrayList<>();
        HBox boxField = new HBox();
        double height = size*1.618;
        boxField.setMinWidth((size+10)*counts+10);
        boxField.setAlignment(Pos.CENTER);
        HBox spaces = new HBox();
        spaces.setMinSize(20,20);
        boxField.getChildren().add(spaces);
        for (int i=0; i<counts; i++) {
            HBox b = new HBox();
            b.setMinSize(size,height);
            b.setAlignment(Pos.CENTER);
            b.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
            boxes.add(b);
            FieldController.setFieldClick(boxes.size()-1,p);
            FieldController.setFieldHover(boxes.size()-1,p);
            boxField.getChildren().add(boxes.get(boxes.size()-1));
            spaces = new HBox();
            spaces.setMinSize(20,20);
            boxField.getChildren().add(spaces);
        }
        return boxField;
    }

    /**
     * Refreshes the field view, so new cards put in the field will be shown, and such
     * @param p Player who owns the field
     */
    public static void initField(Player p){
        int x = p == State.p1 ? 12 : 0;
        for (int i = 0 + x; i < 12 + x; i++){
            boxes.get(i).getChildren().clear();
            if (p.getSummonedCards().get(i) != null){
                BorderPane card = Card.drawCard(p.getSummonedCards().get(i),100);
                if (p == State.p2) card.setRotate(180);
                if (!p.getCardInfo().get(i).getValue()) card.setRotate(90);
                if (i == State.clickField) card.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
                boxes.get(i).getChildren().add(card); 
            }
        }
    }
}