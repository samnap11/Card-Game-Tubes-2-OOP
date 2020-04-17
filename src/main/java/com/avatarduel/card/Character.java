package com.avatarduel.card;


import com.avatarduel.field.Field;

public class Character extends Card {
    protected int attack;
    protected int defense;
    protected int power_cost;

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
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getPower_cost() {
        return power_cost;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setPower_cost(int power_cost) {
        this.power_cost = power_cost;
    }

    public String getDetails(){
        return String.format("ATK %d DEF %d %s",attack,defense,element);
    }
}
