package com.avatarduel.field;


import java.util.*;
import com.avatarduel.card.Character;
// import com.avatarduel.model.Skill;

public class FieldTileCharacter{
    private Optional<Character> isi;

    public FieldTileCharacter(){

    }

    public void setCard(Character C){
        isi = Optional.of(C);
    }

    public Optional<Character> getCard(){
        return isi;
    }

    public void remove(){
        if (isi.isPresent()){
            isi = isi.empty();
        }
    }


}