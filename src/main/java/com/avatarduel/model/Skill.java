package com.avatarduel.model;

public abstract class Skill extends Card {
    int power_cost;

    public Skill(String name, String description, Element element, int power_cost) {
        super(name, description, element);
        this.power_cost = power_cost;
    }

    public int getPower_cost() {
        return power_cost;
    }

    public void setPower_cost(int power_cost) {
        this.power_cost = power_cost;
    }

    @Override
    public void place(Field field) throws CardException {
        // TODO: show field list, pick one, then give the effect to the selected one.
        effect();
    }

    @Override
    public void discard() {

    }

    abstract public void effect(SummonedCharacter summonedCharacter);
}
