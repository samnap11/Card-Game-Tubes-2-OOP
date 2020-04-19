package com.avatarduel.card;


// import com.avatarduel.field.Field;
import com.avatarduel.player.Player;
import com.avatarduel.gui.*;
import javafx.util.Pair;

public class Character extends Card implements HasCost{
    protected int attack;
    protected int defense;
    protected int power_cost;
    protected int attackBonus;
    protected int defenseBonus;

    /**
     * constructor of character cards
     * @param name the name of the card
     * @param description the description of the card
     * @param element the element of the card
     * @param img the imagepath of the card
     * @param attack the attack value of the card
     * @param defense the defense value of the card
     * @param power_cost the cost to summon the card
     */
    public Character(String name, String description, Element element,String img, int attack, int defense, int power_cost) {
        super(name, description, element,img);
        this.attack = attack;
        this.defense = defense;
        this.power_cost = power_cost;
        this.attackBonus = 0;
        this.defenseBonus = 0;
    }

    /**
     * default constructor of the card
     */
    public Character(){
        super();
        this.attack = 0;
        this.defense = 0;
        this.power_cost = 0;
        this.attackBonus = 0;
        this.defenseBonus = 0;
    }

    /**
     * Getter of the attack value of the card
     * @return the attack value of the card
     */
    public int getAttack() {
        return attack + attackBonus;
    }

    /**
     * Getter of the defense value of the card
     * @return the defense value of the card
     */
    public int getDefense() {
        return defense + defenseBonus;
    }

    /**
     * Getter of the cost to summon the card
     * @return the cost to summon the card
     */
    public int getCost() {
        return power_cost;
    }

    /**
     * Setter for the attack value of the card
     * @param attack the attack value of the card
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Setter for the defense value of the card
     * @param defense the defense value of the card
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Getter of the total bonus value of the card from the aura card
     * @return the total value of the attack and defense bonus from aura card
     */
    public int getBonus(){
        return attackBonus + defenseBonus;
    }

    /**
     * Applying bonus from aura card to the character card
     * @param attack the value of the attack bonus
     * @param defense the value of the defense bonus
     */
    public void giveBonus(int attack, int defense){
        attackBonus += attack;
        defenseBonus += defense;
    }

    /**
     * Taking away the bonus value which given by the aura card
     * @param attack the value of the attack bonus
     * @param defense the value of the defense bonus
     */
    public void takeBonus(int attack, int defense){
        attackBonus -= attack;
        defenseBonus -= defense;
    }

    /**
     * Setter for the cost to summon the character card
     * @param power_cost the cost to summon the character card
     */
    public void setPower_cost(int power_cost) {
        this.power_cost = power_cost;
    }

    /**
     * Getter for the details of the card
     * @return the details of the card
     */
    public String getDetails(){
        return String.format("ATK %d DEF %d %s\nCOST %d",getAttack(),getDefense(),element,power_cost);
    }

    /**
     * Simulate the battle of two character cards
     * @param p1 player 1
     * @param p2 player 2
     * @param attack the attack value of the other card
     * @param defense the defense value of the other card
     */
    public static void Battle(Player p1, Player p2, int attack, int defense){
        p1.getCardInfo().put(attack, new Pair<>(true,true));
        if (defense == -1){
            p2.setHp(p2.getHp()-((Character)p1.getSummonedCards().get(attack)).getAttack());
            HealthView.updateHp(p2);
            return;
        }
        int attackVal = ((Character)p1.getSummonedCards().get(attack)).getAttack();
        int defenderVal = p2.getCardInfo().get(defense).getValue() ? ((Character) p2.getSummonedCards().get(defense)).getAttack() : ((Character) p2.getSummonedCards().get(defense)).getDefense();
        int calc = attackVal - defenderVal;
        if (calc > 0){
            if (p2.getCardInfo().get(defense).getValue() || p1.getPowerUp().contains(attack)){
                System.out.printf("defense %d\n",defense);
                p2.setHp(p2.getHp() - calc);
            }
            p2.removeFieldCard(defense);
            HealthView.updateHp(p2);
        }else if (calc == 0){
            p2.removeFieldCard(defense);
            p1.removeFieldCard(attack);
        }else{
            p1.removeFieldCard(attack);
            p1.setHp(p1.getHp() + calc);
            HealthView.updateHp(p1);
        }
    }
}
