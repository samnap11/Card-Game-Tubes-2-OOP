package com.avatarduel.field;

import java.util.*;
import javafx.util.Pair;

import com.avatarduel.*;
import com.avatarduel.model.Element;

class Field{
    private ArrayList<FieldTileCharacter> CField;
    private ArrayList<FieldTileSpell> SField;
    private Map<Element,Pair<Integer,Integer>> Land;
    private Element el;


    public Field(){
        CField = new ArrayList<>();
        for (int i = 0; i < 7; i ++){
            CField.add(new FieldTileCharacter());
        }
        SField = new ArrayList<>();
        for (int i = 0; i < 7; i ++){
            SField.add(new FieldTileSpell());
        }
        Land = new HashMap<>();
        Land.put(el.WATER,new Pair<Integer,Integer>(1,1));
        Land.put(el.EARTH,new Pair<Integer,Integer>(1,1));
        Land.put(el.FIRE,new Pair<Integer,Integer>(1,1));
        Land.put(el.AIR,new Pair<Integer,Integer>(1,1));
    }

    public void addCard(int i, Card C){
        if (C instanceof CharacterCard){
            CField.get(i).setCard(C);
        }else if (C instanceof SpellCard){
            SField.get(i).setCard(C);
        }else{
            return;
        }
        
    }

    public void LandCard(Card C){

    }

}