package com.avatarduel.field;

import java.util.*;
import javafx.util.Pair;

import com.avatarduel.*;
import com.avatarduel.card.Element;
import com.avatarduel.card.Card;
import com.avatarduel.card.Character;
import com.avatarduel.card.Skill;

public class Field{
    private ArrayList<FieldTileCharacter> CField;
    private ArrayList<FieldTileSkill> SField;
    private Map<Element,Pair<Integer,Integer>> Land;
    private Element el;


    public Field(){
        CField = new ArrayList<>();
        for (int i = 0; i < 7; i ++){
            CField.add(new FieldTileCharacter());
        }
        SField = new ArrayList<>();
        for (int i = 0; i < 7; i ++){
            SField.add(new FieldTileSkill());
        }
        Land = new HashMap<>();
        Land.put(el.WATER,new Pair<Integer,Integer>(1,1));
        Land.put(el.EARTH,new Pair<Integer,Integer>(1,1));
        Land.put(el.FIRE,new Pair<Integer,Integer>(1,1));
        Land.put(el.AIR,new Pair<Integer,Integer>(1,1));
    }

    // public void addCard(int i, Card C) throws WrongCardException{
    //     if (C instanceof Character){
    //         CField.get(i).setCard(C);
    //     }else if (C instanceof Skill){
    //         SField.get(i).setCard(C);
    //     }else{
    //         throw new WrongCardException();
    //     }
        
    // }

    public void LandCard(Card C){

    }

}
