package com.avatarduel.card;


// import com.avatarduel.field.Field;
import com.avatarduel.player.Player;
import com.avatarduel.gui.*;

/**
 * Land card which will provide power to the player
 * @author Samuel
 */
public class Land extends Card {
    int power_provided;

    /**
     * Constructor for the land of the card
     * @param name the name of the card
     * @param description the description text of the card
     * @param element the element of the card
     * @param img the imagepath of the card
     * @param power_provided the power which the card provides
     */
    public Land(String name, String description, Element element,String img, int power_provided) {
        super(name,description,element,img);
        this.power_provided = power_provided;
    }

    /**
     * Default constructor of the land card
     */
    public Land(){
        super();
        this.power_provided = 0;
    }

    /**
     * Getter for the power which the card provides
     * @return the power which the card provides
     */
    public int getPower_provided() {
        return power_provided;
    }

    /**
     * Setter for the power which the card provides
     * @param power_provided the power which the card provides
     */
    public void setPower_provided(int power_provided) {
        this.power_provided = power_provided;
    }

    /**
     * Activation of the card
     * @param p the player which has the card
     */
    public void activate(Player p){
        p.addElement(element,power_provided);
        FieldSide.updateLand(p);
    }

    /**
     * Getter for the details of the card
     * @return the details of the card
     */
    public String getDetails(){
        return String.format("LAND %s %d",element,power_provided);
    }

}
