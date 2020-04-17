package com.avatarduel.gui;

import com.avatarduel.state.State;
import com.avatarduel.card.*;
import com.avatarduel.player.Player;
import com.avatarduel.controller.*;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;


public class HandView{
    public static HBox p1Hand = new HBox();
    public static HBox p2Hand = new HBox();

    public static void init(){
        p1Hand.setMinWidth(800);
        p1Hand.setAlignment(Pos.CENTER);
        p2Hand.setMinWidth(800);
        p2Hand.setAlignment(Pos.CENTER);
        initP1();
        initP2();
    }

    public static void initP1(){
        p1Hand.getChildren().clear();
        for (int i = 0; i < State.p1.sizeHand(); i ++){
            Card card = State.p1.peekCard(i);
            BorderPane view = Card.drawCard(card,60);
            HandController.showOnHover(view,State.p1,i);
            HandController.setOnClicked(view,State.p1,i);
            if (i == State.clickHand) view.setBorder(new Border(new BorderStroke(Color.LIGHTBLUE,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
            if (State.turn % 2 == 1) p1Hand.getChildren().add(view);
            else p1Hand.getChildren().add(Card.closedCard(60));
        }
    }

    public static void initP2(){
        p2Hand.getChildren().clear();
        for (int i = 0; i < State.p2.sizeHand(); i ++){
            Card card = State.p2.peekCard(i);
            BorderPane view = Card.drawCard(card,60);
            HandController.showOnHover(view,State.p2,i);
            HandController.setOnClicked(view,State.p2,i);
            if (i + 10 == State.clickHand) view.setBorder(new Border(new BorderStroke(Color.LIGHTBLUE,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
            if (State.turn % 2 == 0) p2Hand.getChildren().add(view);
            else p2Hand.getChildren().add(Card.closedCard(60));
        }
    }
}