package com.avatarduel.card;

import com.avatarduel.player.Player;

public class PowerUp extends Skill {
    public PowerUp(String name, String description, Element element, String img, int power_cost) {
        super(name, description, element, img, power_cost);
    }

    @Override
    public void effect(Player p,int idx) {
        // summonedCharacter.setPoweredUp(true);
        p.powerUp.add(idx);
        setTarget(idx);
    }

    @Override
    public void deeffect(Player p,int idx) {
        p.powerUp.remove(idx);
        setTarget(-1);
    }

    public String getDetails(){
        return String.format("PU %s COST %d",element,power_cost);
    }
}
