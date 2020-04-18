package com.avatarduel.controller;

import javafx.scene.layout.*;

import com.avatarduel.card.*;
import com.avatarduel.gui.*;
import com.avatarduel.state.*;
import com.avatarduel.player.*;
// import com.avatarduel.


public class FieldController{

    public static void setFieldClick(int idx,Player p){
        FieldG.boxes.get(idx).setOnMouseClicked(e ->{
            boolean rightturn = p == State.p1 ? State.turn == 1 : State.turn ==2;
            if (rightturn && State.clickHand != -1 && State.gamePhase == Phase.MAIN && ((idx > 5 && idx < 18 && p.peekCard(p == State.p1 ? State.clickHand : State.clickHand - 10) instanceof com.avatarduel.card.Character))){
                if (p.summonedCards.get(idx) == null){
                    p.placeAtField(State.clickHand,idx);
                    State.clickHand = -1;
                    HandView.init();
                }
            }
        }
        );
    }

    public static void setFieldHover(int idx, Player P){
            FieldG.boxes.get(idx).setOnMouseEntered(e ->{
                // System.out.println(idx);
                if (P.summonedCards.get(idx) != null)
                    FieldG.changeDisplay(P.summonedCards.get(idx));
            });
    }
}