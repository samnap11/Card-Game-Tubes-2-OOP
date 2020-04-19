package com.avatarduel.card;

// import com.avatarduel.field.Field;
import com.avatarduel.player.Player;
// import com.sun.jmx.snmp.SnmpUnknownModelException;

/**
 * Skill card which provides certain effect to a targeted character card
 * This card is a child class of Card
 * @author Samuel
 */
public abstract class Skill extends Card implements HasCost{
    protected int power_cost;
    protected int target;

    /**
     * Constructor for the skill card
     * @param name the name of the card
     * @param description the description of the card
     * @param element the element of the card
     * @param img the imagepath of the card
     * @param power_cost the cost to summon the card
     */
    public Skill(String name, String description, Element element,String img, int power_cost) {
        super(name, description, element,img);
        this.power_cost = power_cost;
        target = -1;
    }

    /**
     * Getter for the cost to summon the card
     * @return the cost to summon the card
     */
    public int getCost() {
        return power_cost;
    }

    /**
     * Setter for the cost to summon the card
     * @param power_cost the cost to summon the card
     */
    public void setPower_cost(int power_cost) {
        this.power_cost = power_cost;
    }

    /**
     * Setter for the target of the card
     * @param _target the target card
     */
    public void setTarget(int _target){
        target = _target;
    }

    /**
     * Getter for the target of the card
     * @return the target card
     */
    public int getTarget(){
        return target;
    }

    /**
     * Giving the effect to a card
     * @param p the player which has the targeted card
     * @param idx the index of the targeted card
     */
    abstract public void effect(Player p,int idx);

    /**
     * Taking the effect away from a card
     * @param p the player which has the targeted card
     * @param idx the index of the targeted card
     */
    abstract public void deeffect(Player p,int idx);
}
