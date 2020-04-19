package com.avatarduel.deck;
import java.util.*;

import com.avatarduel.card.Card;
import java.util.Collections;

public class Deck {
    public Stack<Card> isi;
    public int kap;
    
    public Deck(){
        // user = " ";
        isi = new Stack<>();
        kap = 60;

    }
    public Deck(int kap){
        isi = new Stack<>();
        this.kap = kap;
    }

    public int getSize(){
        return isi.size();
    }
    // melakukan pengocokan stack supaya isi menjadi acak
    // tidak dapat dilakukan shuffle kalo stack kosong
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
    // buat ngisi kartu kedalam deck
    //outputnya deck sesuai ukuran stack
    public void inputDeck(ArrayList<Card> Cards){
        for (int i = 0; i < Cards.size() && i < kap; i++){
            // System.out.printf("Hai\n");
            isi.push(Cards.get(i));
        }
    }

    //melakukan pop satu kartu dan mengurangi size
    //tidak dapat melakukan pop jika kosong
    public Card Draw(){
        return isi.pop();
    }
    
}