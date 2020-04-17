package com.avatarduel.card;

public class PowerUp extends Skill {
    public PowerUp(String name, String description,String img, Element element, int power_cost) {
        super(name, description, element,img, power_cost);
    }

    @Override
    public void effect(SummonedCharacter summonedCharacter) {

    }

    public String getDetails(){
        return String.format("PU %s",element);
    }
}