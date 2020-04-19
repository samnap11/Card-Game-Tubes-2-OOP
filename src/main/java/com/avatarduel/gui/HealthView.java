package com.avatarduel.gui;

import com.avatarduel.gui.*;
import com.avatarduel.player.Player;
import com.avatarduel.state.State;

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
 * HealthView is responsible for updating visualization of each player's health
 * @author mee
 */
public class HealthView{
    public static ProgressBar healthp1 = new ProgressBar();
    
    public static ProgressBar healthp2 = new ProgressBar();

    /**
     * Initialize hpbar
     * @param pe Player of said hp bar
     * @param barHp the bar to change
     * @return The instance of the health bar to add to the right parent
     */
    public static BorderPane hpBar(Player pe, ProgressBar barHp){
        int maxHp = 80;
        double curHP;
        BorderPane barPane = new BorderPane();
        HBox plane = new HBox();

        curHP = (double)pe.getHp()/maxHp;
        barHp.setProgress(curHP);
        barHp.setMinWidth(700);
        barHp.setMinHeight(10);

        barPane.setMinWidth(800);

        Text hp = new Text("HP");
        hp.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        hp.setFill(Color.WHITE);

        Text valHP = new Text(String.valueOf(pe.getHp()));
        valHP.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        valHP.setFill(Color.WHITE);

        plane.getChildren().add(hp);
        plane.getChildren().add(barHp);
        plane.getChildren().add(valHP);
        barPane.setCenter(plane);

        return barPane;
    }
    
    /**
     * Update hp
     * @param p Player whose health changed
     */
    public static void updateHp(Player p){
        ProgressBar pb = p == State.p1 ? healthp1 : healthp2;
        pb.setProgress(((double)p.getHp())/80.0);
    }
}