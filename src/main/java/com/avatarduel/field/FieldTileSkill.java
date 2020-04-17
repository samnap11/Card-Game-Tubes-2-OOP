package com.avatarduel.field;
// import com.avatarduel.model.Character;
import com.avatarduel.card.Skill;

import java.util.*;


public class FieldTileSkill{
    private Optional<Skill> isi;

    public FieldTileSkill(){

    }

    public void setCard(Skill C){
        isi = Optional.of(C);
    }

    public Optional<Skill> getCard(){
        return isi;
    }
}