package com.avatarduel.state;


import com.avatarduel.player.Player;
import com.avatarduel.gui.Buttons;
import com.avatarduel.card.CardLoader;
import com.avatarduel.gui.*;
import com.avatarduel.deck.Deck;

import javafx.scene.layout.*;
import javafx.scene.control.*;

/**
 * State of the game
 * @author me
 */
public class State{
    public static Phase gamePhase;//0 drawing,1 main, 2 battle, 3 main2 ,4 end
    public static int turn;
    public static Player p1,p2;
    public static int clickHand;
    public static int clickField;

    /**
     * initialize game state
     */
    public static void init(){
        CardLoader a = new CardLoader();
        // Deck all = new Deck(300);
        
        p1 = new Player();
        p2 = new Player();
        try{
            p1.fillDeck(a.loadCards());
            p2.fillDeck(a.loadCards());
        }catch(Exception E){
        }
        for (int i =0 ; i < 9; i ++)
            p1.getDeck().shuffle();
        for (int i =0 ; i < 22; i ++)
            p2.getDeck().shuffle();
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

    /**
     * Change the phase to next
     */
    public static void nextPhase(){
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
    }   

    /**
     * Check turn
     * @param p checked player
     * @return true if it is p's turn
     */
    public static boolean checkTurn(Player p){
        return p == p1 ? turn == 1 : turn == 2;
    }

    /**
     * Ending turn
     */
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
        FieldView.initField(State.p1);
        FieldView.initField(State.p2);
    }


}