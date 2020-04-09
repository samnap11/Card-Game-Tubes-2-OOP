package com.avatarduel.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterController implements Initializable{

    @FXML private AnchorPane AnchorPane;
    @FXML private Pane mainPane;
    @FXML private TextField playerOne;
    @FXML private TextField playerTwo;
    @FXML private Pane titlePane;
    @FXML private Button startButton;

    public void initialize(URL url, ResourceBundle rb){
        setTitle("file:images/asd.jpg");
    }

    public void setTitle(String pict){
        Image image = new Image(pict);
        BackgroundImage backgroundImage = new BackgroundImage(image,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.DEFAULT,
        new BackgroundSize(30,70,true,true,false,true));
        
        Background background = new Background(backgroundImage);
        titlePane.setBackground(background);
    }

    

}