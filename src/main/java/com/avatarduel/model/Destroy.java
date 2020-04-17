package com.avatarduel.model;

public class Destroy extends Skill {
    public Destroy(String name, String description, Element element,String img, int power_cost) {
        super(name, description, element,img, power_cost);
    }

    @Override
    public void effect(SummonedCharacter summonedCharacter) {
        summonedCharacter.getCharacter().discard();
    }

    public String getDetails(){
        return String.format("Destroy %s",element);
    }
}
