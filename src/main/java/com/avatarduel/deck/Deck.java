package com.avatarduel.deck;
import java.util.*;

import com.avatarduel.card.Card;
import java.util.Collections;

public class Deck {
    public Stack<Card> isi;
    public int kap;
    
    //default inzialitazion deck with root capacity 60 and stack 0
    public Deck(){
        isi = new Stack<>();
        kap = 60;

    }
    //inizalitzation with input capacity
    public Deck(int kap){
        isi = new Stack<>();
        this.kap = kap;
    }
    //return update size in deck
    public int getSize(){
        return isi.size();
    }
    //doing shuffle to card in deck
    public void shuffle(){
        List<Card> dck = new ArrayList<>();
        for(Card i: isi){
            dck.add(i);
        }
        Collections.shuffle(dck);
        isi.clear();
        for (Card j : dck){
            isi.push(j);
        }
    }
    //input card to deck 
    public void inputDeck(ArrayList<Card> Cards){
        for (int i = 0; i < Cards.size() && i < kap; i++){
            // System.out.printf("Hai\n");
            isi.push(Cards.get(i));
        }
    }

    //take one card from deck
    public Card Draw(){
        return isi.pop();
    }
    
}