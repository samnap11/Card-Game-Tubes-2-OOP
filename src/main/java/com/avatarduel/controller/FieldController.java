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
            System.out.println(idx);
            System.out.println(State.clickHand);
            System.out.println("Clicked");
            boolean rightturn = p == State.p1 ? State.turn == 1 : State.turn ==2;
            if (rightturn && State.clickHand != -1 && State.gamePhase == Phase.MAIN){
                if (p.summonedCards.get(idx) == null){
                    int click = p == State.p1 ? State.clickHand : State.clickHand - 10;
                    p.summonedCards.put(idx,p.peekCard(click));
                    FieldG.boxes.get(idx).getChildren().add(Card.drawCard(p.peekCard(click),100));
                    p.removeHand(click);
                    State.clickHand = -1;
                    HandView.init();
                }
            }
        }
        );
    }
}