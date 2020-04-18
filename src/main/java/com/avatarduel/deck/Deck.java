package com.avatarduel.deck;
import java.util.*;

import com.avatarduel.card.Card;
import java.util.Collections;

public class Deck {
    // private String user;
    public Stack<Card> isi;
    public int kap;
    public Deck(){
        // user = " ";
        isi = new Stack<>();
        kap = 60;

    }
    public Deck(int kap){
        // user = usr;
        isi = new Stack<>();
        this.kap = kap;
    }

    public int getSize(){
        return isi.size();
    }
    // melakukan pengocokan stack supaya isi menjadi acak
    // tidak dapat dilakukan shuffle kalo stack kosong
    public void shuffle(){
        // Random a = new Random();
        // Card temp;
        // List<Card> dck = new ArrayList<>();
        // for(Card i: isi){
        //     dck.add(i);
        // }
        // int mid = dck.size()/(a.nextInt(2)+2);
        // int i = dck.size()-1;

        // for(int k = 0;k <a.nextInt(20);k++){
        //     while(mid > 0){
        //         temp = dck.get(mid);
        //         dck.set(mid, dck.get(i));
        //         dck.set(i,temp);
        //         mid--;
        //         i--;
        //     }
        // }
        // isi.clear();
        // for(Card j: dck){
        //     isi.push(j);
        // }
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
        // for(int i = 0;i <card.length;i++){
        //     isi.push(card[i]);
        // }
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