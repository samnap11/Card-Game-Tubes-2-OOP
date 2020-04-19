package com.avatarduel.card;


import com.avatarduel.player.Player;

public class Aura extends Skill {
    protected int attack_change;
    protected int defense_change;

    /**
     *
     * @param name the name of the aura card
     * @param description the description of the aura card
     * @param element the element of the aura card
     * @param img the image of the aura card
     * @param power_cost the cost to summon the aura card
     * @param attack_change the attack change which the aura card gives
     * @param defense_change the defense change which the aura card gives
     */
    public Aura(String name, String description, Element element,String img, int power_cost, int attack_change, int defense_change) {
        super(name,description,element,img,power_cost);
        this.attack_change = attack_change;
        this.defense_change = defense_change;
    }

    /**
     *
     * @return the attack change which the aura card gives
     */
    public int getAttack_change() {
        return attack_change;
    }

    /**
     *
     * @return the defense change which the aura card gives
     */
    public int getDefense_change() {
        return defense_change;
    }

    /**
     *
     * @param attack_change the attack change which the aura card gives
     */
    public void setAttack_change(int attack_change) {
        this.attack_change = attack_change;
    }

    /**
     *
     * @param defense_change the defense change which the aura card gives
     */
    public void setDefense_change(int defense_change) {
        this.defense_change = defense_change;
    }

    /**
     *
     * @return the attributes and details of the aura card
     */
    public String getDetails(){
        return String.format("Aura %s COST %d\n ATT %d DEF %d",element,getCost(),attack_change,defense_change);
    }

    /**
     *
     * @param p the player which has the aura card
     * @param idx the index of the character card that will get the changes from aura card
     */
    @Override
    public void effect(Player p,int idx) {
        ((com.avatarduel.card.Character) p.getSummonedCards().get(idx)).giveBonus(attack_change,defense_change);
        setTarget(idx);
    }

    /**
     *
     * @param p the player which has the aura card
     * @param idx the index of the character card that get stripped of the changes from the aura card
     */
    @Override
    public void deeffect(Player p, int idx){
        ((Character) p.getSummonedCards().get(idx)).takeBonus(attack_change,defense_change);
        setTarget(-1);
    }
}
