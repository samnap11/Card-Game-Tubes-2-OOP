package com.avatarduel.deck;

import com.avatarduel.*;
import java.util.*;

import com.avatarduel.card.Card;
import com.avatarduel.card.CardLoader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDeck {

	@Test
	void test() {
		ArrayList<Card> isi = new ArrayList<Card>();
		CardLoader a = new CardLoader();
		Deck dck = new Deck(25);
		assertEquals(0, dck.getSize());
		try{
            for(Card i : a.loadCards()) {
            	isi.add(i);
            }
        }catch(Exception E){
        }
		dck.inputDeck(isi);
		assertEquals(25,dck.getSize());
		assertEquals(dck.Draw(),isi.get(24)); //because inputDeck is stack proccess
		dck.shuffle();
		//assertEquals(dck.Draw(),isi.get(24)); //fail because deck has been shuffled
		
	}

}
