package com.avatarduel.player;
import java.util.*;

import com.avatarduel.model.Card;
import com.avatarduel.model.Element;
import javafx.util.Pair;
import javafx.scene.layout.*;
import com.avatarduel.gui.CardG;
import com.avatarduel.deck.Deck;

public class Player {
    private int hp;
    protected ArrayList<Card> hand;
    public Deck pDeck;
    protected Map<Element, Pair<Integer,Integer>> element;
    private Map<Integer,Card> summonedCards;
    private HBox healthBar = new HBox();

    public Player(){
        this.hp = 80;
        this.hand = new ArrayList<>();
        this.summonedCards = new HashMap<>();
        this.element = new HashMap<>();
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
        Card now = pDeck.Draw();
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

    public String getLand(Element e){
        // Pair<int,int> = element.get(e);
        return String.format("%d/%d",element.get(e).getKey(),element.get(e).getValue());
    }
}
