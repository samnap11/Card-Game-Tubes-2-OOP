package com.avatarduel.card;

import com.avatarduel.player.Player;
import com.avatarduel.state.State;

public class Destroy extends Skill {
    public Destroy(String name, String description, Element element,String img, int power_cost) {
        super(name, description, element,img, power_cost);
    }

    @Override
    public void effect(Player p,int idx) {
        // summonedCharacter.setDestroyed(true);
        Player p2 = p == State.p1 ? State.p2 : State.p1;
        p2.removeFieldCard(idx);
    }

    // @Override
    // public void deeffect(SummonedCharacter summonedCharacter) {

    // }

    public String getDetails(){
        return String.format("Destroy %s COST %d",element,getCost());
    }
}
