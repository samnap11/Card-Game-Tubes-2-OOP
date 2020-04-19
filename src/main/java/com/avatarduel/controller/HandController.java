package com.avatarduel.controller;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import com.avatarduel.card.*;
import com.avatarduel.gui.*;
import com.avatarduel.player.Player;
import com.avatarduel.state.*;


/**
 * HandController set hand events based on triggers and flags.
 *
 * @author saya
 */
public class HandController{

    /**
     * Sets hover event of a certain card, of an owner, with index of said card in his hand
     * @param card the gui item given the event
     * @param a owner of the hand item
     * @param idx idx of the card in player's hand
     */
    public static void showOnHover(BorderPane card,Player a, int idx){
        card.setOnMouseEntered(e -> CardView.changeDisplay(a.peekCard(idx)));
    }   

    /**
     * Sets click event of a certain card, of an owner, with index of said card in his hand
     * @param card the gui item given the event
     * @param a owner of the hand item
     * @param idx idx of the card in player's hand
     */
    public static void setOnClicked(BorderPane card, Player a, int idx){
        card.setOnMouseClicked(e -> {
            if(a.peekCard(idx) instanceof HasCost){
                if (State.gamePhase == Phase.MAIN){
                    if (a == State.p1 && a.getElement().get(a.peekCard(idx).getElement()).getKey() >= ((HasCost) a.peekCard(idx)).getCost()){
                        State.clickHand = idx;
                    }
                    else if (a == State.p2 && a.getElement().get(a.peekCard(idx).getElement()).getKey() >= ((HasCost) a.peekCard(idx)).getCost()){
                        State.clickHand = idx + 10;
                    }
                    HandView.initHand(a);
                }   
            }
            else if (a.peekCard(idx) instanceof com.avatarduel.card.Land){
                ((Land) a.peekCard(idx)).activate(a);
                a.removeHand(idx);
            }
        });
    }
}