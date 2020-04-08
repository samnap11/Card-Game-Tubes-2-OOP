package com.avatarduel.field;


import java.util.*;


public class FieldTileSpell{
    private Optional<SpellCard> isi;

    public FieldTileSpell(){

    }

    public void setCard(SpellCard C){
        isi = Optional.of(C);
    }

    public Optional<SpellCard> getCard(){
        return isi;
    }
}