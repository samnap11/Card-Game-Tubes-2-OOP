package com.avatarduel.player;
import java.util.*;

import tubes.Card;

public class Player {
    private int hp;
    protected ArrayList<Card> hand;
    protected Deck pDeck;
    protected Map<Element, Pair<integer,integer>> element;

    public Player(){
        this.hp = 80;
        this.hand = new ArrayList<>();
        this.pDeck = new Deck();
        this.element.put(Element.WATER,new Pair<>(0,0));
        this.element.put(Element.AIR,new Pair<>(0,0));
        this.element.put(Element.FIRE,new Pair<>(0,0));
        this.element.put(Element.EARTH,new Pair<>(0,0));
    }
    
    public int getHp(){
        return this.hp;
    }

    public void setHp(int hp){
        this.hp =hp;
    }

    public void takeCard(){
        Card now= pDeck.Draw();
        hand.add(now);
    }

    public void addElement(Element el){
        Pair<Integer,Integer> temp = element.get(el);
        element.put(el,new Pair<>(temp.getValue()+1,temp.getValue()+1));
    }

    public void resetElement() {
        element.forEach((el,per)->{
            element.put(el, new Pair<>(per.getValue(),per.getValue()));
        });
    }

    public Card peekCard(int x){
        if (hand.size() > x) return hand.get(x);
        return null;
    }

    public int sizeHand(){
        return hand.size();
    }

    public void removeHand(int x){
        if (hand.size() > x) hand.remove(x);
    }

    public void removeHandCard(Card cx){
        if (hand.contains(cx)) hand.remove(hand.indexOf(cx));
    }
}
