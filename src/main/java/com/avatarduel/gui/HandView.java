package com.avatarduel.gui;

import com.avatarduel.state.State;
import com.avatarduel.card.*;
import com.avatarduel.player.Player;
import com.avatarduel.controller.*;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;

/**
 * HandView is responsible for updating visualization of each player's hand
 * @author mee
 */
public class HandView{
    public static HBox p1Hand = new HBox();
    public static HBox p2Hand = new HBox();


    /**
     * Initialize handviews
     */
    public static void init(){
        p1Hand.setMinWidth(800);
        p1Hand.setAlignment(Pos.CENTER);
        p2Hand.setMinWidth(800);
        p2Hand.setAlignment(Pos.CENTER);
        // initP1();
        // initP2();
        initHand(State.p1);
        initHand(State.p2);
    }

    /**
     * Refreshes hand view of player P based on current events
     * @param p Hand owner
     */
    public static void initHand(Player p){
        HBox hand = p == State.p1 ? p1Hand : p2Hand;
        hand.getChildren().clear();
        for (int i = 0; i < p.sizeHand(); i ++){
            Card card = p.peekCard(i);
            // System.out.printf("%s\n",card.getImg());
            BorderPane view = Card.drawCard(card,60);
            HandController.showOnHover(view,p,i);
            HandController.setOnClicked(view,p,i);
            if (p == State.p2) view.setRotate(180);
            if ((i == State.clickHand) || (i + 10 == State.clickHand)) view.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
            if (State.checkTurn(p)) hand.getChildren().add(view);
            else hand.getChildren().add(Card.closedCard(60));
        }
    }
}