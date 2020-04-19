package com.avatarduel.card;



public abstract class Card {
    protected String name;
    protected String description;
    protected Element element;
    protected String img;

    /**
     * Constructor of card
     * @param name the name of the card
     * @param desc the description of the card
     * @param element the element of the card
     * @param img the imagepath of the card
     */
    public Card(String name, String desc, Element element,String img) {
        this.name = name;
        this.description = desc;
        this.element = element;
        this.img = img;
    }

    /**
     * default constructor of Card
     */
    public Card(){
        this.name = "";
        this.description = "";
        this.element = null;
        this.img = "";
    }

    /**
     * Getter for the name of the card
     * @return the name of the card
     */
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Getter for the element of the card
     * @return the element of the card
     */
    public Element getElement() {
        return element;
    }

    /**
     * Setter for the name of the card
     * @param name the name of the card
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the imagepath of the card
     * @return the imagepath of the card
     */
    public String getImg(){
        return img;
    }

    /**
     * Setter for the description text of the card
     * @param description the description text the card
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *  Setter for the element of the card
     * @param element the element of the card
     */
    public void setElement(Element element) {
        this.element = element;
    }

    abstract public String getDetails();
}
