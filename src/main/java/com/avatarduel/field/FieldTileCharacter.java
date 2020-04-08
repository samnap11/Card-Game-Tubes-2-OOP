package com.avatarduel.field;


import java.util.*;


public class FieldTileCharacter{
    private Optional<CharacterCard> isi;

    public FieldTileCharacter(){

    }

    public void setCard(CharacterCard C){
        isi = Optional.of(C);
    }

    public Optional<CharacterCard> getCard(){
        return isi;
    }
}