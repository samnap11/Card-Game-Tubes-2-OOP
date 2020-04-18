package com.avatarduel.card;


import com.avatarduel.field.Field;
import com.avatarduel.player.Player;
import com.avatarduel.gui.*;

public class Land extends Card {
    int power_provided;

    public Land(String name, String description, Element element,String img, int power_provided) {
        super(name,description,element,img);
        this.power_provided = power_provided;
    }

    public Land(){
        super();
        this.power_provided = 0;
    }

    public int getPower_provided() {
        return power_provided;
    }

    public void setPower_provided(int power_provided) {
        this.power_provided = power_provided;
    }

    public void activate(Player p){
        p.addElement(element,power_provided);
        FieldG.updateLand(p);
    }

    public String getDetails(){
        return String.format("LAND %s %d",element,power_provided);
    }

}
