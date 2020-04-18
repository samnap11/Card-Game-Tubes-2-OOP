package com.avatarduel.card;


import com.avatarduel.field.Field;

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
        this.img = "";
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

    abstract public String getDetails();

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
