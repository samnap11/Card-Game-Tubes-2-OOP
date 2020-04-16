package com.avatarduel.model;


import com.avatarduel.field.Field;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.image.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;

public abstract class Card {
    protected String name;
    protected String description;
    protected Element element;
    protected String img;

    public static Card getSuzy(){
        return new Character("Suzy Bae with Glasses","Can't blame gravity to fall in love with this",Element.WATER,"com/bae.jpg",99,99,99);
    }

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
        this.img = "com/bae.jpg";
    }

    public String getName() {
        return name;
    }

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

    public static BorderPane drawCard(Card X, int width){
        double height = width * 1.618; //golden ratio motherfucker
        BorderPane card = new BorderPane();
        card.setMinWidth(width);
        card.setMinHeight(height);
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
        name.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        name.getChildren().add(new Text(Name));

        cardName.getChildren().add(name);


        HBox cardPic = new HBox();
        cardPic.setMinHeight(height / 2);
        cardPic.setMinWidth(width * 0.8);
        cardPic.setAlignment(Pos.CENTER);
        cardPic.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));

        ImageView image = new ImageView();
        image.setFitWidth(width * 0.8);
        image.setFitHeight(height / 2);
        image.setImage(new Image(X.img));

        cardPic.getChildren().add(image);


        VBox cardDesc = new VBox();
        cardDesc.setMinHeight(height*135/400);
        cardDesc.setAlignment(Pos.CENTER);

        HBox descText = new HBox();
        descText.setMaxWidth(width*21/25);
        descText.setMinHeight(height*7/40);
        descText.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        // descText.getChildren().add(new Label(X.description)); // unwrapped
        Label desc = new Label(X.description);
        desc.setWrapText(true);
        descText.getChildren().add(desc);

        HBox attDef = new HBox();   //harusnya isinya attack defend kalo mcharacter tapi klo bukan char gimana ya?????/
        attDef.setMinHeight(height * 0.1);
        attDef.setAlignment(Pos.CENTER);
        attDef.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(1))));
        attDef.getChildren().add(new Label(X.getElement().toString()));
        
        cardDesc.getChildren().add(descText);
        cardDesc.getChildren().add(attDef);
        

        card.setTop(cardName);
        card.setCenter(cardPic);
        card.setBottom(cardDesc);

        return card;
    }
}
