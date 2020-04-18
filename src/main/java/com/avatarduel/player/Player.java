package com.avatarduel.player;
import com.avatarduel.card.Card;
import com.avatarduel.card.Element;
import com.avatarduel.deck.Deck;

import java.util.*;

import com.avatarduel.card.Card;
import com.avatarduel.card.Element;
import javafx.util.Pair;
import javafx.scene.layout.*;
import com.avatarduel.gui.*;
import com.avatarduel.deck.Deck;
import com.avatarduel.state.State;

public class Player {
    private int hp;
    protected ArrayList<Card> hand;
    public Deck pDeck;
    protected Map<Element, Pair<Integer,Integer>> element;
    public Map<Integer,Card> summonedCards;
    private HBox healthBar = new HBox();

    public Player(){
        this.hp = 80;
        this.hand = new ArrayList<>();
        this.summonedCards = new HashMap<>();
        this.element = new HashMap<>();
        this.pDeck = new Deck();
        this.element.put(Element.WATER,new Pair<>(1,1));
        this.element.put(Element.AIR,new Pair<>(1,1));
        this.element.put(Element.FIRE,new Pair<>(1,1));
        this.element.put(Element.EARTH,new Pair<>(1,1));
    }
    
    public void removeHand(int idx){
        hand.set(idx,null);
        hand.remove(null);
        HandView.initHand(this);
        this.hp -= 10;
    }

    public int getHp(){
        return this.hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public void takeCard(){
        Card now = pDeck.Draw();
        hand.add(now);
        FieldG.updateDeckSize(this);
    }

    public void fillDeck(ArrayList<Card> a){
        pDeck.inputDeck(a);
    }

    public void addElement(Element el,int x){
        Pair<Integer,Integer> temp = element.get(el);
        element.put(el,new Pair<>(temp.getValue()+x,temp.getValue()+x));
    }

    public void resetElement() {
        element.forEach((el,per)->{
            element.put(el, new Pair<>(per.getValue(),per.getValue()));
        });
    }

    public Card peekCard(int x){
        // int x = this == State.p1 ? idx : idx - 10;
        if (hand.size() > x) return hand.get(x);
        return null;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public int sizeHand(){
        return hand.size();
    }


    public void turnInit(){
        if (sizeHand() < 10)
            takeCard();
        resetElement();
    }

    public void placeAtField(int clickHand, int idx){
        int click = this == State.p1 ? State.clickHand : State.clickHand - 10;
        summonedCards.put(idx,peekCard(click));
        FieldG.boxes.get(idx).getChildren().add(Card.drawCard(peekCard(click),100));
        removeHand(click);
    }
    // public void removeHand(int x){
    //     if (hand.size() > x) hand.remove(x);
    // }

    public void removeHandCard(Card cx){
        if (hand.contains(cx)) hand.remove(hand.indexOf(cx));
    }

    public String getLand(Element e){
        // Pair<int,int> = element.get(e);
        return String.format("%d/%d",element.get(e).getKey(),element.get(e).getValue());
    }
}
