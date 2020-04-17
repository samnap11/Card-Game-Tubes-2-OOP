package com.avatarduel.card;

import com.avatarduel.field.Field;

public abstract class Skill extends Card {
    int power_cost;

    public Skill(String name, String description, Element element,String img, int power_cost) {
        super(name, description, element,img);
        this.power_cost = power_cost;
    }

    public int getPower_cost() {
        return power_cost;
    }

    public void setPower_cost(int power_cost) {
        this.power_cost = power_cost;
    }

    abstract public void effect(SummonedCharacter summonedCharacter);
}
