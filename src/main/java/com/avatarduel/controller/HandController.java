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
        card.setOnMouseEntered(e -> FieldG.changeDisplay(a.peekCard(idx)));
    }   

    public static void setOnClicked(BorderPane card, Player a, int idx){
        card.setOnMouseClicked(e -> clickCard(card,a,idx));
    }

    public static void clickCard(BorderPane card, Player a, int idx){
        if(a.peekCard(idx) instanceof com.avatarduel.card.Character){
            if (State.gamePhase == Phase.MAIN){
                if (a == State.p1){
                    State.clickHand = idx;
                    // HandView.initP1();
                }
                else{
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
        // card.setBorder(new Border(new BorderStroke(Color.LIGHTBLUE,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
    }
}