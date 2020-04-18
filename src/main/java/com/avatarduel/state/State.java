package com.avatarduel.state;


import com.avatarduel.player.Player;
import com.avatarduel.gui.Buttons;
import com.avatarduel.card.CardLoader;
import com.avatarduel.gui.*;
import com.avatarduel.deck.Deck;

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
        // Deck all = new Deck(300);
        
        p1 = new Player();
        p2 = new Player();
        try{
            // all.inputDeck(a.loadCards());
            // System.out.println("Hai\n");
            p1.fillDeck(a.loadCards());
            p2.fillDeck(a.loadCards());
            // System.out.printf("%d\n%d\n",p1.pDeck.isi.size(),p2.pDeck.isi.size());
        }catch(Exception E){
        }
        for (int i =0 ; i < 9; i ++)
            p1.pDeck.shuffle();
        for (int i =0 ; i < 22; i ++)
            p2.pDeck.shuffle();
        for (int i = 0; i < 6; i++){
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
            State.clickHand = -1;
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

    public static boolean checkTurn(Player p){
        return p == p1 ? turn == 1 : turn == 2;
    }

    public static void endTurn(){
        Buttons.init();
        if (turn % 2 == 1){
            p2.turnInit();
        }
        else{
            p1.turnInit();
        }
        State.clickField = -1;
        State.clickHand = -1;
        gamePhase = Phase.MAIN;
        turn = turn % 2 + 1;
        HandView.initHand(State.p1);
        HandView.initHand(State.p2);
        FieldG.initField(State.p1);
        FieldG.initField(State.p2);
    }


}