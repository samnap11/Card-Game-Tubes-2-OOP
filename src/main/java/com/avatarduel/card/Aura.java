package com.avatarduel.card;

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
        return String.format("Aura %s",element);
    }

    @Override
    public void effect(SummonedCharacter summonedCharacter) {
        int oldAttack = summonedCharacter.getCharacter().getAttack();
        int oldDefense = summonedCharacter.getCharacter().getDefense();
        summonedCharacter.getCharacter().setAttack(oldAttack + attack_change);
        summonedCharacter.getCharacter().setDefense(oldDefense + defense_change);
    }

    @Override
    public void deeffect(SummonedCharacter summonedCharacter) {
        int oldAttack = summonedCharacter.getCharacter().getAttack();
        int oldDefense = summonedCharacter.getCharacter().getDefense();
        summonedCharacter.getCharacter().setAttack(oldAttack - attack_change);
        summonedCharacter.getCharacter().setDefense(oldDefense - defense_change);
    }
}
