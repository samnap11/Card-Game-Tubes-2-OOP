package com.avatarduel.card;



public abstract class Card {
    protected String name;
    protected String description;
    protected Element element;
    protected String img;

    public Card(String name, String desc, Element element,String img) {
        this.name = name;
        this.description = desc;
        this.element = element;
        this.img = img;
    }

    public Card(){
        this.name = "";
        this.description = "";
        this.element = null;
        this.img = "";
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

    public String getImg(){
        return img;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    abstract public String getDetails();
}
