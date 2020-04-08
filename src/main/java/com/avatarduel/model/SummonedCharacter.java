package com.avatarduel.model;

public class SummonedCharacter implements ISummon {
    Character character;
    boolean attackPos;
    boolean faceUp;

    public SummonedCharacter(Character character) {
        this.character = character;
        attackPos = true;
        faceUp = true;
    }

    public Character getCharacter() {
        return character;
    }

    public boolean isAttackPos() {
        return attackPos;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    @Override
    public void flip() {
        if(!faceUp) {
            faceUp = true;
        }
    }

    @Override
    public void rotate() {
        if(!attackPos) {
            attackPos = true;
        }
    }

    @Override
    public int getValue() {
        if(attackPos) {
            return character.getAttack();
        }
        else {
            return character.getDefense();
        }
    }
}
