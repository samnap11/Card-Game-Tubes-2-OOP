package com.avatarduel.card;

public class PowerUp extends Skill {
    public PowerUp(String name, String description, Element element, int power_cost) {
        super(name, description, element, power_cost);
    }

    @Override
    public void effect(SummonedCharacter summonedCharacter) {

    }
}
