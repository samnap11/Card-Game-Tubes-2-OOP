package com.avatarduel.model;

public class Character extends Card {
    protected int attack;
    protected int defense;
    protected int power_cost;

    public Character(String name, String description, Element element, int attack, int defense, int power_cost) {
        super(name, description, element);
        this.attack = attack;
        this.defense = defense;
        this.power_cost = power_cost;
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

    @Override
    public void place(Field field) throws CardException {

    }

    @Override
    public void discard() {

    }
}
