package com.avatarduel.card;


// import com.avatarduel.field.Field;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;

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

    /**
     * Getter for the color of the card
     * @return the color of the card depending on the element of the card
     */
    public Color getColor(){
        if (element == Element.WATER){
            return Color.LIGHTBLUE;
        }
        else if (element == Element.AIR){
            return Color.TEAL;
        }
        else if (element == Element.FIRE){
            return Color.RED;
        }
        else if (element == Element.EARTH){
            return Color.YELLOW;
        }
        return Color.WHITE;
    }

    /**
     * Getter for the description text of the card
     * @return the description text of the card
     */
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

    /**
     * Displaying the card
     * @param X the card which will be displayed
     * @param width the width of the card
     * @return the display of the card
     */
    public static BorderPane drawCard(Card X, int width){
        double height = width * 1.618; //golden ratio motherfucker
        BorderPane card = new BorderPane();
        card.setMinWidth(width);
        card.setMinHeight(height);
        card.setMaxWidth(width);
        card.setMaxHeight(height);
        card.setBorder(new Border(new BorderStroke(Color.WHITE,BorderStrokeStyle.SOLID,null, new BorderWidths(4))));
        String Name;
        Element el;

        // if (X != null){
        Name = X.getName();
        el = X.getElement();
        // }
        card.setBackground(new Background(new BackgroundFill(X.getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
        HBox cardName = new HBox();
        cardName.setMinHeight(height * 0.125);
        cardName.setAlignment(Pos.CENTER);

        HBox name = new HBox();
        name.setMinWidth(width * 0.8);
        name.setMaxHeight(height * 0.1);
        name.setAlignment(Pos.CENTER);
        name.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
        if (width > 150) name.getChildren().add(new Text(Name));

        cardName.getChildren().add(name);


        HBox cardPic = new HBox();
        cardPic.setMinHeight(height / 2);
        cardPic.setMinWidth(width * 0.8);
        cardPic.setMaxWidth(width * 0.8);
        cardPic.setAlignment(Pos.CENTER);
        // cardPic.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));

        ImageView image = new ImageView();
        image.setFitWidth(width * 0.8);
        image.setFitHeight(height / 2);
        if (X.img != ""){
            image.setImage(new Image(X.img));
        }
        
        cardPic.getChildren().add(image);


        VBox cardDesc = new VBox();
        cardDesc.setMinHeight(height*0.3);
        cardDesc.setAlignment(Pos.CENTER);

        HBox descText = new HBox();
        descText.setMaxWidth(width*0.8);
        descText.setMinHeight(height*7/40);
        descText.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
        // descText.getChildren().add(new Label(X.description)); // unwrapped
        Label desc = new Label(X.description);
        desc.setWrapText(true);
        if (width > 150) descText.getChildren().add(desc);

        HBox attDef = new HBox();   //harusnya isinya attack defend kalo mcharacter tapi klo bukan char gimana ya?????/
        attDef.setMinHeight(height * 0.01);
        attDef.setMaxWidth(width * 0.8);
        attDef.setAlignment(Pos.CENTER);
        attDef.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
        if (X instanceof com.avatarduel.card.Character){
            if (((Character) X).getBonus() > 0) attDef.setBorder(new Border(new BorderStroke(Color.GREEN,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
            else if (((Character) X).getBonus() < 0) attDef.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
        }
        Label det = new Label(X.getDetails());
        det.setFont(new Font("Arial",12));
        if (width > 150) attDef.getChildren().add(det);
        
        cardDesc.getChildren().add(descText);
        cardDesc.getChildren().add(attDef);
        

        card.setTop(cardName);
        card.setCenter(cardPic);
        card.setBottom(cardDesc);

        return card;
    }

    /**
     * Displaying the card in the condition of closed
     * @param width the width of the card which will be displayed
     * @return the display of the back cover of the card
     */
    public static BorderPane closedCard(double width){
        double height = width * 1.618;
        BorderPane closed = new BorderPane();
        closed.setMinWidth(width);
        closed.setMinHeight(height);
        closed.setMaxHeight(height);
        closed.setBackground(new Background(new BackgroundFill(Color.valueOf("4d2204"), CornerRadii.EMPTY, Insets.EMPTY)));
        closed.setBorder(new Border(new BorderStroke(Color.valueOf("9c6d00"),BorderStrokeStyle.SOLID,null, new BorderWidths(3))));
        // closed.setAlignment(Pos.CENTER);

        // HBox circle = new HBox();
        // circle.setAlignment(Pos.CENTER);

        Circle circ = new Circle(width*0.25);
        circ.setFill(Color.BLACK);

        // circle.getChildren().add(circ);
        closed.setCenter(circ);
        return closed;
    }
}
