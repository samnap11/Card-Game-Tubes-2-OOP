package com.avatarduel.state;


import com.avatarduel.player.Player;
import com.avatarduel.gui.Buttons;
import com.avatarduel.card.CardLoader;
import com.avatarduel.gui.*;

import javafx.scene.layout.*;
import javafx.scene.control.*;

public class State{
    public static Phase gamePhase;//0 drawing,1 main, 2 battle, 3 main2 ,4 end
    public static int turn;
    public static Player p1,p2;
    public static int clickHand;
    public static int clickField;


    public static void init(){
        CardLoader a = new CardLoader();
        p1 = new Player();
        p2 = new Player();
        try{
            // System.out.println("Hai\n");
            p1.fillDeck(a.loadCards());
            p2.fillDeck(a.loadCards());
            System.out.printf("%d\n%d\n",p1.pDeck.isi.size(),p2.pDeck.isi.size());
        }catch(Exception E){
        }
        for (int i =0 ; i < 5; i ++)
            p1.pDeck.shuffle();
        for (int i =0 ; i < 10; i ++)
            p2.pDeck.shuffle();
        for (int i = 0; i < 7; i++){
            p1.takeCard();
            p2.takeCard();
        }
        HandView.init();
        gamePhase = Phase.MAIN;
        turn = 1;
        clickHand = -1;
        clickField = -1;
    }

    public static void nextPhase(){
        System.out.println(State.gamePhase);
        if (gamePhase == Phase.DRAW){
            gamePhase = Phase.MAIN;
        }
        else if (gamePhase == Phase.MAIN){
            gamePhase = Phase.BATTLE;
        }
        else if (gamePhase == Phase.BATTLE){
            gamePhase = Phase.END;
        }
        else if (gamePhase == Phase.END){
            gamePhase = Phase.MAIN;
        }
        System.out.println(State.gamePhase);
    }

    public static void endTurn(){
        Buttons.init();
        // System.out.println(State.turn);a
        if (turn % 2 == 1){
            // System.out.println("halo");
            // System.out.printf("%d\n",p2.pDeck.isi.size());
            if (p2.sizeHand() < 10)
                p2.takeCard();
        }
        else{
            if (p1.sizeHand() < 10)
                p1.takeCard();

        }
        // nextPhase();
        gamePhase = Phase.MAIN;
        turn = turn % 2 + 1;
        HandView.initP1();
        HandView.initP2();
        // FieldG.gameView();
    }


}