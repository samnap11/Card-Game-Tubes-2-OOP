package com.avatarduel.player;
import com.avatarduel.card.Card;
import com.avatarduel.card.Element;
import com.avatarduel.deck.Deck;

import java.util.*;

import com.avatarduel.card.*;
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
    public Map<Element, Pair<Integer,Integer>> element;
    public Map<Integer,Card> summonedCards;
    public Map<Integer,Pair<Boolean,Boolean>> cardInfo;
    public List<Integer> powerUp;
    private HBox healthBar = new HBox();

    public Player(){
        this.hp = 80;
        this.hand = new ArrayList<>();
        this.summonedCards = new HashMap<>();
        this.element = new HashMap<>();
        this.cardInfo = new HashMap<>();
        this.powerUp = new ArrayList<>();
        this.pDeck = new Deck();
        this.element.put(Element.WATER,new Pair<>(100,100));
        this.element.put(Element.AIR,new Pair<>(100,100));
        this.element.put(Element.FIRE,new Pair<>(100,100));
        this.element.put(Element.EARTH,new Pair<>(100,100));
        this.element.put(Element.ENERGY,new Pair<>(100,100));
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
        resetInfo();
    }

    public void resetInfo(){
        for (int idx : cardInfo.keySet()){
            cardInfo.put(idx,new Pair<>(false,cardInfo.get(idx).getValue()));
        }
    }

    public void placeAtField(int idx){
        int click = this == State.p1 ? State.clickHand : State.clickHand - 10;
        element.put(peekCard(click).getElement(),new Pair<>(element.get(peekCard(click).getElement()).getKey() - ((com.avatarduel.card.Character) peekCard(click)).getCost(),element.get(peekCard(click).getElement()).getValue()));
        summonedCards.put(idx,peekCard(click));
        FieldG.boxes.get(idx).getChildren().add(Card.drawCard(peekCard(click),100));
        cardInfo.put(idx,new Pair<>(false,true));
        // setChosen(idx,this);
        removeHand(click);
        FieldG.updateLand(this);
    }
    
    public void useSkill(int idx){
        int click = State.checkTurn(State.p1) ? State.clickHand : State.clickHand - 10;
        Player p = idx > 11 ? State.p1 : State.p2;
        ((Skill) peekCard(click)).effect(p,idx);
        element.put(peekCard(click).getElement(),new Pair<>(element.get(peekCard(click).getElement()).getKey() - ((HasCost) peekCard(click)).getCost(),element.get(peekCard(click).getElement()).getValue()));
        int x = this == State.p1 ? 18 : 0;
        for (int i = x; i < x+6; i ++){
            if (summonedCards.get(i) == null){
                System.out.printf("%d\n%s\n",i,peekCard(click).getDetails());
                summonedCards.put(i,peekCard(click));
                FieldG.boxes.get(i).getChildren().add(Card.drawCard(peekCard(click),100));
                cardInfo.put(i,new Pair<>(true,true));
                break;
            }
        }
        State.clickHand = -1;
        removeHand(click);
        FieldG.initField(this);
    }

    public void removeHandCard(Card cx){
        if (hand.contains(cx)) hand.remove(hand.indexOf(cx));
    }

    public String getLand(Element e){
        // Pair<int,int> = element.get(e);
        return String.format("%d/%d",element.get(e).getKey(),element.get(e).getValue());
    }

    public void removeFieldCard(int idx){
        summonedCards.remove(idx);
        cardInfo.remove(idx);
        FieldG.initField(this);
    }

    public boolean canBattle(int idx){
        return cardInfo.get(idx).getKey();
    }
}
