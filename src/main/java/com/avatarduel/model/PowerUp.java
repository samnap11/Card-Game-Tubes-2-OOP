package com.avatarduel.model;

public class PowerUp extends Skill {
    public PowerUp(String name, String description,String img, Element element, int power_cost) {
        super(name, description, element,img, power_cost);
    }

    @Override
    public void effect(SummonedCharacter summonedCharacter) {

    }
}
