package com.avatarduel.model;

public class Land extends Card {
    int power_provided;

    public Land(String name, String description, Element element, int power_provided) {
        super(name,description,element);
        this.power_provided = power_provided;
    }

    public int getPower_provided() {
        return power_provided;
    }

    public void setPower_provided(int power_provided) {
        this.power_provided = power_provided;
    }

    @Override
    public void place(Field field) throws CardException {

    }

    @Override
    public void discard() {

    }
}
