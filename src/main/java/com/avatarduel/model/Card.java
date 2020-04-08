package com.avatarduel.model;

public abstract class Card {
    protected String name;
    protected String description;
    protected Element element;

    public Card(String name, String desc, Element element) {
        this.name = name;
        this.description = desc;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Element getElement() {
        return element;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    abstract public void place(Field field) throws CardException;

    abstract  public void discard();
}
