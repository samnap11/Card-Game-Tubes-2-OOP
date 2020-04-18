package com.avatarduel.card;

public class PowerUp extends Skill {
    public PowerUp(String name, String description, Element element, String img, int power_cost) {
        super(name, description, element, img, power_cost);
    }

    @Override
    public void effect(SummonedCharacter summonedCharacter) {
        summonedCharacter.setPoweredUp(true);
    }

    @Override
    public void deeffect(SummonedCharacter summonedCharacter) {
        summonedCharacter.setPoweredUp(false);
    }

    public String getDetails(){
        return String.format("PU %s",element);
    }
}
