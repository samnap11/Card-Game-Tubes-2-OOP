package com.avatarduel.card;

import com.avatarduel.player.Player;
import com.avatarduel.state.State;

/**
 * Destroy card to destroy a targeted character card
 * This class is a child class of Skill
 * @author Samuel
 */
public class Destroy extends Skill {
    /**
     * Constructor of the destroy card
     * @param name the name of the destroy card
     * @param description the description text of the destroy card
     * @param element the element of the destroy card
     * @param img the imagepath of the destroy card
     * @param power_cost the cost to summon the destroy card
     */
    public Destroy(String name, String description, Element element,String img, int power_cost) {
        super(name, description, element,img, power_cost);
    }

    /**
     * Destroy a card
     * @param p the player which has the targeted card
     * @param idx the index of the targeted card on the player p field
     */
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

    /**
     * Taking away the effect of the card
     * @param p the player which has the targeted card
     * @param idx the index of the targeted card on the player p field
     */
    @Override
    public void deeffect(Player p,int idx) {
        
    }

    /**
     * Getter for the details of the card
     * @return the details of the card
     */
    public String getDetails(){
        return String.format("Destroy %s COST %d",element,getCost());
    }
}
