package com.avatarduel.card;

// import com.avatarduel.field.Field;
import com.avatarduel.player.Player;
// import com.sun.jmx.snmp.SnmpUnknownModelException;

public abstract class Skill extends Card implements HasCost{
    protected int power_cost;
    protected int target;

    public Skill(String name, String description, Element element,String img, int power_cost) {
        super(name, description, element,img);
        this.power_cost = power_cost;
        target = -1;
    }

    public int getCost() {
        return power_cost;
    }

    public void setPower_cost(int power_cost) {
        this.power_cost = power_cost;
    }

    public void setTarget(int _target){
        target = _target;
    }

    public int getTarget(){
        return target;
    }

    abstract public void effect(Player p,int idx);

    abstract public void deeffect(Player p,int idx);
}
