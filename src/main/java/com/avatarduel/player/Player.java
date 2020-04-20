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


/**
 * Representation of a Player
 */
/**
 * Player is the component based player who play the game
 * @author Devin
 */
public class Player {
    private int hp;
    protected ArrayList<Card> hand;
    private Deck pDeck;
    private Map<Element, Pair<Integer,Integer>> element;
    private Map<Integer,Card> summonedCards;
    private Map<Integer,Pair<Boolean,Boolean>> cardInfo;
    private List<Integer> powerUp;
    private HBox healthBar = new HBox();

    /**
     * Default constuctor of player
     */
    public Player(){
        this.hp = 80;
        this.hand = new ArrayList<>();
        this.summonedCards = new HashMap<>();
        this.element = new HashMap<>();
        this.cardInfo = new HashMap<>();
        this.powerUp = new ArrayList<>();
        this.pDeck = new Deck();
        this.element.put(Element.WATER,new Pair<>(1,1));
        this.element.put(Element.AIR,new Pair<>(1,1));
        this.element.put(Element.FIRE,new Pair<>(1,1));
        this.element.put(Element.EARTH,new Pair<>(1,1));
        this.element.put(Element.ENERGY,new Pair<>(1,1));
    }
    
    /**
     * delete card on the hand at index idx
     * @param idx
     */
    public void removeHand(int idx){
        hand.set(idx,null);
        hand.remove(null);
        HandView.initHand(this);
    }
    /**
     * getter for the element of the card
     * @return element the element of the card
     */
    public Map<Element,Pair<Integer,Integer>> getElement(){
        return element;
    }   

    /**
     * getter for the summoned cards
     * @return cards that have summoned before
     */
    public Map<Integer,Card> getSummonedCards(){
        return summonedCards;
    }
    
    /**
     * getter for the card info
     * @return card info
     */
    public Map<Integer,Pair<Boolean,Boolean>> getCardInfo(){
        return cardInfo;
    }  


    /**
     * getter powerup
     * @return powerup
     */
    public List<Integer> getPowerUp(){
        return powerUp;
    }

    /**
     * getter deck of cards
     * @return deck of cards
     */
    public Deck getDeck(){
        return pDeck;
    }                        
                    
    /**
     * getter health points
     * @return health points
     */
    public int getHp(){
        return this.hp;
    }

    /**
     * setter health points
     * @param hp
     */
    public void setHp(int hp){
        this.hp = hp;
    }

    /**
     * take card from the deck and put it on the hand
     */
    public void takeCard(){
        Card now = pDeck.Draw();
        hand.add(now);
        FieldSide.updateDeckSize(this);
    }

    /**
     * input arraylist of cards into deck
     * @param a
     */
    public void fillDeck(ArrayList<Card> a){
        pDeck.inputDeck(a);
    }

    /**
     * add element according to each type of element
     * @param el
     * @param x
     */
    public void addElement(Element el,int x){
        Pair<Integer,Integer> temp = element.get(el);
        element.put(el,new Pair<>(temp.getValue()+x,temp.getValue()+x));
    }

    /**
     * reset element
     */
    public void resetElement() {
        element.forEach((el,per)->{
            element.put(el, new Pair<>(per.getValue(),per.getValue()));
        });
    }

    /**
     * getter card on the hand at index x
     * @param x
     * @return card or null
     */
    public Card peekCard(int x){
        // int x = this == State.p1 ? idx : idx - 10;
        if (hand.size() > x) return hand.get(x);
        return null;
    }

    /**
     * getter hand
     * @return hand with cards or without
     */
    public ArrayList<Card> getHand(){
        return hand;
    }

    /**
     * getter size of hand
     * @return size of hand
     */
    public int sizeHand(){
        return hand.size();
    }

    /**
     * drawphase
     */
    public void turnInit(){
        if (sizeHand() < 10)
            takeCard();
        resetElement();
        resetInfo();
    }

    /**
     * reset card info
     */
    public void resetInfo(){
        for (int idx : cardInfo.keySet()){
            cardInfo.put(idx,new Pair<>(false,cardInfo.get(idx).getValue()));
        }
    }

    /**
     * place card on the field
     * @param idx index card at the field 
     */
    public void placeAtField(int idx){
        int click = this == State.p1 ? State.clickHand : State.clickHand - 10;
        element.put(peekCard(click).getElement(),new Pair<>(element.get(peekCard(click).getElement()).getKey() - ((com.avatarduel.card.Character) peekCard(click)).getCost(),element.get(peekCard(click).getElement()).getValue()));
        summonedCards.put(idx,peekCard(click));
        FieldView.boxes.get(idx).getChildren().add(CardView.drawCard(peekCard(click),100));
        cardInfo.put(idx,new Pair<>(false,true));
        // setChosen(idx,this);
        removeHand(click);
        FieldSide.updateLand(this);
    }
    
    /**
     * use skill card
     * @param idx index card
     */
    public void useSkill(int idx){
        int click = State.checkTurn(State.p1) ? State.clickHand : State.clickHand - 10;
        Player p = idx > 11 ? State.p1 : State.p2;
        ((Skill) peekCard(click)).effect(p,idx);
        element.put(peekCard(click).getElement(),new Pair<>(element.get(peekCard(click).getElement()).getKey() - ((HasCost) peekCard(click)).getCost(),element.get(peekCard(click).getElement()).getValue()));
        int x = this == State.p1 ? 18 : 0;
        if (!(peekCard(click) instanceof Destroy))
        for (int i = x; i < x+6; i ++){
            if (summonedCards.get(i) == null){
                // System.out.printf("%d\n%s\n",i,peekCard(click).getDetails());
                summonedCards.put(i,peekCard(click));
                FieldView.boxes.get(i).getChildren().add(CardView.drawCard(peekCard(click),100));
                cardInfo.put(i,new Pair<>(true,true));
                break;
            }
        }
        State.clickHand = -1;
        removeHand(click);
        FieldView.initField(this);
    }

    /**
     * delete card cx on the hand
     * @param cx card
     */
    public void removeHandCard(Card cx){
        if (hand.contains(cx)) hand.remove(hand.indexOf(cx));
    }

    /**
     * getter available amount of element and total amount of element
     * @param e element of card
     * @return
     */
    public String getLand(Element e){
        // Pair<int,int> = element.get(e);
        return String.format("%d/%d",element.get(e).getKey(),element.get(e).getValue());
    }

    /**
     * delete card on the field at index idx
     * @param idx index card on the field
     */
    public void removeFieldCard(int idx){
        summonedCards.remove(idx);
        cardInfo.remove(idx);
        destroyUsedAt(idx);
        FieldView.initField(this);
    }

    /**
     * delete skill card
     * @param idx index card on the field
     */
    public void destroyUsedAt(int idx){
        for (int i : State.p1.summonedCards.keySet()){
            if (State.p1.summonedCards.get(i) instanceof Skill){
                if (((Skill) State.p1.summonedCards.get(i)).getTarget() == idx || ((Skill) State.p1.summonedCards.get(i)).getTarget() == -1){
                    State.p1.summonedCards.put(i,null);
                    State.p1.cardInfo.remove(i);
                }
            }
        }
        for (int i : State.p2.summonedCards.keySet()){
            if (State.p2.summonedCards.get(i) instanceof Skill){
                if (((Skill) State.p2.summonedCards.get(i)).getTarget() == idx || ((Skill) State.p2.summonedCards.get(i)).getTarget() == -1){
                    State.p2.summonedCards.put(i,null);
                    State.p2.cardInfo.remove(i);
                }
            }
        }
    }

    /**
     * 
     * @param idx
     * @return
     */
    public boolean canBattle(int idx){
        return cardInfo.get(idx).getKey();
    }
}
