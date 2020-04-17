package com.avatarduel.field;
// import com.avatarduel.model.Character;
import com.avatarduel.card.Skill;

import java.util.*;


public class FieldTileSpell{
    private Optional<Skill> isi;

    public FieldTileSpell(){

    }

    public void setCard(Skill C){
        isi = Optional.of(C);
    }

    public Optional<Skill> getCard(){
        return isi;
    }
}