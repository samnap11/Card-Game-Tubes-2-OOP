package com.avatarduel.controller;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import com.avatarduel.card.*;
import com.avatarduel.gui.*;
import com.avatarduel.state.*;
import com.avatarduel.player.*;

/**
 * FieldController set field events based on triggers and flags.
 *
 * @author saya
 */
public class FieldController{

    /**
     * Set event for clicks on the field box according to the owner with said index in the box list
     * @param idx index of box in the boxlist
     * @param p owner of box
     */
    public static void setFieldClick(int idx,Player p){// p here is owner of the clicked field
        FieldView.boxes.get(idx).setOnMouseClicked(e ->{
            Player pl = State.checkTurn(State.p1) ? State.p1 : State.p2; //Player doing the click
            int click = State.checkTurn(State.p1) ? State.clickHand : State.clickHand - 10;
            if (State.clickHand != -1 && State.checkTurn(p) && p.peekCard(click) instanceof com.avatarduel.card.Character && State.gamePhase == Phase.MAIN && ((idx > 5 && idx < 18/* && p.peekCard(p == State.p1 ? State.clickHand : State.clickHand - 10) instanceof com.avatarduel.card.Character*/))){
                if (p.peekCard(click) instanceof com.avatarduel.card.Character)
                    if (p.getSummonedCards().get(idx) == null){
                        p.placeAtField(idx);
                        State.clickHand = -1;
                        HandView.init();
                    }
            }else if(State.clickHand != -1 && State.gamePhase == Phase.MAIN && pl.peekCard(click) instanceof Skill){
                if (p.getSummonedCards().get(idx) != null)
                    pl.useSkill(idx);
            }else if (State.checkTurn(p) && State.gamePhase == Phase.BATTLE){
                if (p.getSummonedCards().get(idx) != null){
                    if (p.getCardInfo().get(idx).getKey() == false && p.getCardInfo().get(idx).getValue() == true)
                        State.clickField = idx;
                }
            }else if (!State.checkTurn(p) && State.gamePhase == Phase.BATTLE && State.clickField != -1){
                if (!((p == State.p1 ? State.p1 : State.p2).getSummonedCards().isEmpty())){
                    if ((p == State.p1 ? State.p1 : State.p2).getSummonedCards().get(idx) != null){
                        com.avatarduel.card.Character.Battle((p == State.p1 ? State.p2 : State.p1),p, State.clickField, idx);          
                    }
                }else{
                    com.avatarduel.card.Character.Battle((p == State.p1 ? State.p2 : State.p1),p, State.clickField, -1);
                }
                State.clickField = -1;
            }else if (State.checkTurn(p) && State.gamePhase == Phase.MAIN){
                p.getCardInfo().put(idx,new Pair<>(p.getCardInfo().get(idx).getKey(),!p.getCardInfo().get(idx).getValue()));
            }
            FieldSide.updateLand(State.p1);
            FieldSide.updateLand(State.p2);
            FieldView.initField(State.p2);
            FieldView.initField(State.p1);
        }
        );
    }

    /**
     * Set event for hovers on the field box according to the owner with said index in the box list
     * @param idx index of box in the boxlist
     * @param P owner of box
     */
    public static void setFieldHover(int idx, Player P){
            FieldView.boxes.get(idx).setOnMouseEntered(e ->{
                if (P.getSummonedCards().get(idx) != null)
                    CardOnDisplay.changeDisplay(P.getSummonedCards().get(idx));
            });
    }
}