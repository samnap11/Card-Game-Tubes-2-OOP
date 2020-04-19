package com.avatarduel.card;

import com.avatarduel.player.Player;

/**
 * Power Up card which will provides bonus (positive or negative)
 * to a character card
 * This class is a child class of Skill
 * @author Samuel
 */
public class PowerUp extends Skill {
    /**
     * Constructor for the power up card
     * @param name the name of the card
     * @param description the description text of the card
     * @param element the element of the card
     * @param img the imagepath of the card
     * @param power_cost the cost to summon the card
     */
    public PowerUp(String name, String description, Element element, String img, int power_cost) {
        super(name, description, element, img, power_cost);
    }

    /**
     * Giving the power up effect of the card
     * @param p the player which has the targeted card
     * @param idx the index of the targeted card on player p field
     */
    @Override
    public void effect(Player p,int idx) {
        // summonedCharacter.setPoweredUp(true);
        p.getPowerUp().add(idx);
        setTarget(idx);
    }

    /**
     * Taking the power up effect away from a card
     * @param p the player which has the targeted card
     * @param idx the index of the targeted card on player p field
     */
    @Override
    public void deeffect(Player p,int idx) {
        p.getPowerUp().remove(idx);
        setTarget(-1);
    }

    /**
     * Getter for the details of the card
     * @return the details of the card
     */
    public String getDetails(){
        return String.format("PU %s COST %d",element,power_cost);
    }
}
