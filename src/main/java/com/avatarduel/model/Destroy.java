package com.avatarduel.model;

public class Destroy extends Skill {
    public Destroy(String name, String description, Element element, int power_cost) {
        super(name, description, element, power_cost);
    }

    @Override
    public void effect(SummonedCharacter summonedCharacter) {
        summonedCharacter.getCharacter().discard();
    }
}
