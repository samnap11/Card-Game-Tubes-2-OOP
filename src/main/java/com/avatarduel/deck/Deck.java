package com.avatarduel.deck;
import java.util.*;

import com.avatarduel.card.Card;
public class Deck {
    private String user;
    private Stack<Card> isi;
    public Deck(){
        user = " ";
        isi = new Stack<>();

    }
    public Deck( String usr){
        user = usr;
        isi = new Stack<>();
        
    }
    // melakukan pengocokan stack supaya isi menjadi acak
    // tidak dapat dilakukan shuffle kalo stack kosong
    public void Shuffle(){

        Card temp;
        List<Card> dck = new ArrayList<>();
        for(Card i: isi){
            dck.add(i);
        }
        int mid = dck.size()/2;
        int i = dck.size()-1;
        for(int k = 0;k <3;k++){
            while(mid > 0){
                temp = dck.get(mid);
                dck.set(mid, dck.get(i));
                dck.set(i,temp);
                mid--;
                i--;
            }
        }
        isi.clear();
        for(Card j: dck){
            isi.push(j);
        }

    }
    // buat ngisi kartu kedalam deck
    //outputnya deck sesuai ukuran stack
    public void inputDeck(Card[]card){
        for(int i = 0;i <card.length;i++){
            isi.push(card[i]);
        }
    }
    //melakukan pop satu kartu dan mengurangi size
    //tidak dapat melakukan pop jika kosong
    public Card Draw(){
        return isi.pop();
    }
    
}