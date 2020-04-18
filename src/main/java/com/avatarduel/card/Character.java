package com.avatarduel.card;


import com.avatarduel.field.Field;
import com.avatarduel.player.Player;
import com.avatarduel.gui.FieldG;
import javafx.util.Pair;

public class Character extends Card {
    protected int attack;
    protected int defense;
    protected int power_cost;
    protected int attackBonus;
    protected int defenseBonus;

    public Character(String name, String description, Element element,String img, int attack, int defense, int power_cost) {
        super(name, description, element,img);
        this.attack = attack;
        this.defense = defense;
        this.power_cost = power_cost;
    
    }

    public Character(){
        super();
        this.attack = 0;
        this.defense = 0;
        this.power_cost = 0;
        this.attackBonus = 0;
        this.defenseBonus = 0;
    }

    public int getAttack() {
        return attack + attackBonus;
    }

    public int getDefense() {
        return defense + defenseBonus;
    }

    public int getCost() {
        return power_cost;
    }


    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void giveBonus(int attack, int defense){
        attackBonus = attack;
        defenseBonus = defense;
    }

    public void setPower_cost(int power_cost) {
        this.power_cost = power_cost;
    }

    public String getDetails(){
        return String.format("ATK %d DEF %d %s\nCOST %d",attack,defense,element,power_cost);
    }

    public static void Battle(Player p1, Player p2, int attack, int defense){
        p1.cardInfo.put(attack, new Pair<>(true,true));
        if (defense == -1){
            p2.setHp(p2.getHp()-((Character)p1.summonedCards.get(attack)).getAttack());
            FieldG.updateHp(p2);
            return;
        }
        int attackVal = ((Character)p1.summonedCards.get(attack)).getAttack();
        int defenderVal = p2.cardInfo.get(defense).getValue() ? ((Character) p2.summonedCards.get(defense)).getAttack() : ((Character) p2.summonedCards.get(defense)).getDefense();
        int calc = attackVal - defenderVal;
        if (calc > 0){
            p2.removeFieldCard(defense);
            if (p2.cardInfo.get(defense).getValue())
                p2.setHp(p2.getHp() - calc);
            FieldG.updateHp(p2);
        }else if (calc == 0){
            p2.removeFieldCard(defense);
            p1.removeFieldCard(attack);
        }else{
            p1.removeFieldCard(attack);
            p1.setHp(p1.getHp() + calc);
            FieldG.updateHp(p1);
        }
    }
}
