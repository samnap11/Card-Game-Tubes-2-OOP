package com.avatarduel.gui;

import com.avatarduel.gui.*;
import com.avatarduel.player.Player;
import com.avatarduel.state.State;
import com.avatarduel.card.*;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight;
import javafx.scene.paint.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 * CardOnDisplay is responsible in holding the displayed big card with details.
 * 
 *
 * @author Saya
 */
public class CardView{
    
    public static HBox cardDisp = new HBox();

    /**
     * Change the card in display.
     * @param card card to display
     */
    public static void changeDisplay(Card card){
        cardDisp.getChildren().clear();
        cardDisp.getChildren().add(drawCard(card,230));
    }

    public static Color getColor(Card c){
        if (c.getElement() == Element.WATER){
            return Color.LIGHTBLUE;
        }
        else if (c.getElement() == Element.AIR){
            return Color.TEAL;
        }
        else if (c.getElement() == Element.FIRE){
            return Color.RED;
        }
        else if (c.getElement() == Element.EARTH){
            return Color.YELLOW;
        }
        return Color.WHITE;
    }

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
        card.setBackground(new Background(new BackgroundFill(CardView.getColor(X), CornerRadii.EMPTY, Insets.EMPTY)));
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
        if (X.getImg() != ""){
            image.setImage(new Image(X.getImg()));
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
        Label desc = new Label(X.getDescription());
        desc.setWrapText(true);
        if (width > 150) descText.getChildren().add(desc);

        HBox attDef = new HBox();   //harusnya isinya attack defend kalo mcharacter tapi klo bukan char gimana ya?????/
        attDef.setMinHeight(height * 0.01);
        attDef.setMaxWidth(width * 0.8);
        attDef.setAlignment(Pos.CENTER);
        attDef.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
        if (X instanceof com.avatarduel.card.Character){
            if (((com.avatarduel.card.Character) X).getBonus() > 0) attDef.setBorder(new Border(new BorderStroke(Color.GREEN,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
            else if (((com.avatarduel.card.Character) X).getBonus() < 0) attDef.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
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