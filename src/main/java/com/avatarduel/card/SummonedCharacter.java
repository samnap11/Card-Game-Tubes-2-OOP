package com.avatarduel.card;

public class SummonedCharacter implements ISummon {
    Character character;
    boolean attackPos;
    boolean faceUp;
    boolean poweredUp;
    boolean destroyed;

    public SummonedCharacter(Character character) {
        this.character = character;
        attackPos = true;
        faceUp = true;
        poweredUp = false;
        destroyed = false;
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

    public void setPoweredUp(boolean poweredUp) {
        this.poweredUp = poweredUp;
    }

    public boolean isPoweredUp() {
        return poweredUp;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {
        return destroyed;
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
