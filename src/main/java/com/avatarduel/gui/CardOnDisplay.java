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

/**
 * CardOnDisplay is responsible in holding the displayed big card with details.
 * 
 *
 * @author Saya
 */
public class CardOnDisplay{
    
    public static HBox cardDisp = new HBox();

    /**
     * Change the card in display.
     * @param card card to display
     */
    public static void changeDisplay(Card card){
        cardDisp.getChildren().clear();
        cardDisp.getChildren().add(Card.drawCard(card,230));
    }
}