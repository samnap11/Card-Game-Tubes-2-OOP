package com.avatarduel.card;


import com.avatarduel.player.Player;

public class Aura extends Skill {
    protected int attack_change;
    protected int defense_change;

    public Aura(String name, String description, Element element,String img, int power_cost, int attack_change, int defense_change) {
        super(name,description,element,img,power_cost);
        this.attack_change = attack_change;
        this.defense_change = defense_change;
    }

    public int getAttack_change() {
        return attack_change;
    }

    public int getDefense_change() {
        return defense_change;
    }

    public void setAttack_change(int attack_change) {
        this.attack_change = attack_change;
    }

    public void setDefense_change(int defense_change) {
        this.defense_change = defense_change;
    }

    public String getDetails(){
        return String.format("Aura %s COST %d\n ATT %d DEF %d",element,getCost(),attack_change,defense_change);
    } 

    @Override
    public void effect(Player p,int idx) {
        ((com.avatarduel.card.Character) p.summonedCards.get(idx)).giveBonus(attack_change,defense_change);
        setTarget(idx);
    }

    @Override
    public void deeffect(Player p, int idx){
        ((Character) p.summonedCards.get(idx)).takeBonus(attack_change,defense_change);
        setTarget(-1);
    }
}
