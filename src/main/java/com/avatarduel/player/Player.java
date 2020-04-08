import java.util.*;
package com.avatarduel.player;

public class Player {
    private int hp;
    protected Arraylist<Card> hand;
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
        return hand.get(x);
    }

    public int sizeHand(){
        return hand.size;
    }

}
