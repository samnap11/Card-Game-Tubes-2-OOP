package com.avatarduel.state;


import com.avatarduel.player.Player;
import com.avatarduel.gui.Buttons;

import javafx.scene.layout.*;
import javafx.scene.control.*;

public class State{
    public static Phase gamePhase;//0 drawing,1 main, 2 battle, 3 main2 ,4 end
    public static int turn;
    public static Player p1,p2;


    public static void init(){
        p1 = new Player();
        p2 = new Player();
        gamePhase = Phase.DRAW;
        turn = 1;
    }

    public static void nextPhase(){
        if (gamePhase == Phase.DRAW){
            gamePhase = Phase.MAIN;
        }
        if (gamePhase == Phase.MAIN){
            gamePhase = Phase.BATTLE;
        }
        if (gamePhase == Phase.BATTLE){
            gamePhase = Phase.END;
        }
        if (gamePhase == Phase.END){
            gamePhase = Phase.DRAW;
        }
    }

    public static void endTurn(){
        Buttons.init();
        if (turn % 2 == 1){
            State.p2.takeCard();
        }
        else{
            State.p1.takeCard();
        }
        turn = turn % 2 + 1;
    }


}