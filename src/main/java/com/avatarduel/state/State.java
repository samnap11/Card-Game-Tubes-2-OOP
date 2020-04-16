package com.avatarduel.state;


import com.avatarduel.player.Player;

public class State{
    private static Phase gamePhase;//0 drawing,1 main, 2 battle, 3 main2 ,4 end
    private static int turn;
    public static Player p1,p2;

    public static void init(){
        p1 = new Player();
        p2 = new Player();
        gamePhase = Phase.DEFAULT;
        turn = 1;
    }
}