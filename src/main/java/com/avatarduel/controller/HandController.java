package com.avatarduel.controller;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import com.avatarduel.card.*;
import com.avatarduel.gui.*;
import com.avatarduel.player.Player;
import com.avatarduel.state.*;



public class HandController{
    public static void showOnHover(BorderPane card,Player a, int idx){
        card.setOnMouseEntered(e -> CardOnDisplay.changeDisplay(a.peekCard(idx)));
    }   

    public static void setOnClicked(BorderPane card, Player a, int idx){
        card.setOnMouseClicked(e -> clickCard(card,a,idx));
    }

    public static void clickCard(BorderPane card, Player a, int idx){
        if(a.peekCard(idx) instanceof HasCost){
            if (State.gamePhase == Phase.MAIN){
                if (a == State.p1 && a.element.get(a.peekCard(idx).getElement()).getKey() >= ((HasCost) a.peekCard(idx)).getCost()){
                    State.clickHand = idx;
                    // HandView.initP1();
                }
                else if (a == State.p2 && a.element.get(a.peekCard(idx).getElement()).getKey() >= ((HasCost) a.peekCard(idx)).getCost()){
                    State.clickHand = idx + 10;
                    // HandView.initP2();
                }
                HandView.initHand(a);
            }   
        }
        else if (a.peekCard(idx) instanceof com.avatarduel.card.Land){
            ((Land) a.peekCard(idx)).activate(a);
            a.removeHand(idx);
        }
        // else if (a.peekCard(idx) instanceof com.avatarduel.card.Skill){
        //     State.clickHand
        // }
        // card.setBorder(new Border(new BorderStroke(Color.LIGHTBLUE,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
    }
}