package com.avatarduel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent; 
import javafx.scene.image.*;
import javafx.fxml.FXMLLoader;

import com.avatarduel.card.*;
import com.avatarduel.util.CSVReader;
import com.avatarduel.gui.RegView;
import com.avatarduel.state.State;
import com.avatarduel.card.CardLoader;

/**
 * Main Class of the game
 * @author Lab Programming
 */
public class AvatarDuel extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";

  // Stage window;
  // Scene one,two;

  /**
   * Start the application, start() is called upon Application.launch()
   * @param stage the Stage to put the application
   */
  @Override
  public void start(Stage stage){
    
    State.init();
    RegView.loadRegScreen(this);
    Scene scene = new Scene(RegView.Screen);

    stage.setTitle("Avatar Card Game");
    stage.setScene(scene);
    stage.show();
  }

  /**
   * Main method
   * @param args arguments, unused
   */
  public static void main(String[] args) {
    Application.launch();
  }
}