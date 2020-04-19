package com.avatarduel.controller;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import com.avatarduel.card.*;
import com.avatarduel.gui.*;
import com.avatarduel.state.*;
import com.avatarduel.player.*;
// import com.avatarduel.


public class FieldController{

    public static void setFieldClick(int idx,Player p){// p here is owner of the clicked field
        FieldView.boxes.get(idx).setOnMouseClicked(e ->{
            Player pl = State.checkTurn(State.p1) ? State.p1 : State.p2; //Player doing the click
            int click = State.checkTurn(State.p1) ? State.clickHand : State.clickHand - 10;
            if (State.clickHand != -1 && State.checkTurn(p) && p.peekCard(click) instanceof com.avatarduel.card.Character && State.gamePhase == Phase.MAIN && ((idx > 5 && idx < 18/* && p.peekCard(p == State.p1 ? State.clickHand : State.clickHand - 10) instanceof com.avatarduel.card.Character*/))){
                if (p.peekCard(click) instanceof com.avatarduel.card.Character)
                    if (p.summonedCards.get(idx) == null){
                        p.placeAtField(idx);
                        State.clickHand = -1;
                        HandView.init();
                    }
            }else if(State.clickHand != -1 && State.gamePhase == Phase.MAIN && pl.peekCard(click) instanceof Skill){
                if (p.summonedCards.get(idx) != null)
                    pl.useSkill(idx);
            }else if (State.checkTurn(p) && State.gamePhase == Phase.BATTLE){
                if (p.summonedCards.get(idx) != null){
                    if (p.cardInfo.get(idx).getKey() == false && p.cardInfo.get(idx).getValue() == true)
                        State.clickField = idx;
                }
            }else if (!State.checkTurn(p) && State.gamePhase == Phase.BATTLE && State.clickField != -1){
                if (!((p == State.p1 ? State.p1 : State.p2).summonedCards.isEmpty())){
                    if ((p == State.p1 ? State.p1 : State.p2).summonedCards.get(idx) != null){
                        com.avatarduel.card.Character.Battle((p == State.p1 ? State.p2 : State.p1),p, State.clickField, idx);          
                    }
                }else{
                    com.avatarduel.card.Character.Battle((p == State.p1 ? State.p2 : State.p1),p, State.clickField, -1);
                }
                State.clickField = -1;
            }else if (State.checkTurn(p) && State.gamePhase == Phase.MAIN){
                p.cardInfo.put(idx,new Pair<>(p.cardInfo.get(idx).getKey(),!p.cardInfo.get(idx).getValue()));
            }
            FieldSide.updateLand(State.p1);
            FieldSide.updateLand(State.p2);
            FieldView.initField(State.p2);
            FieldView.initField(State.p1);
        }
        );
    }


    public static void setFieldHover(int idx, Player P){
            FieldView.boxes.get(idx).setOnMouseEntered(e ->{
                if (P.summonedCards.get(idx) != null)
                    CardOnDisplay.changeDisplay(P.summonedCards.get(idx));
            });
    }
}