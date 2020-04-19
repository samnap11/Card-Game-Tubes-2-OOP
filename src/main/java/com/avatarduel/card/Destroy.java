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
        // Player p2 = p == State.p1 ? State.p2 : State.p1;
        // Player pl = idx > 11 ? State.p1 : State.p2;
        if (p.getSummonedCards().get(idx) instanceof Skill){
            // p.summonedCharacter.get(p.summonedCharacter.get(idx).getTarget()).takeBonus(p.summonedCharacter.get(idx).get)
            Player pl = ((Skill) p.getSummonedCards().get(idx)).getTarget() > 11 ? State.p1 : State.p2;
            ((Skill) p.getSummonedCards().get(idx)).deeffect(pl,((Skill) p.getSummonedCards().get(idx)).getTarget());
        }
        p.removeFieldCard(idx);
    }

    @Override
    public void deeffect(Player p,int idx) {
        
    }

    public String getDetails(){
        return String.format("Destroy %s COST %d",element,getCost());
    }
}
