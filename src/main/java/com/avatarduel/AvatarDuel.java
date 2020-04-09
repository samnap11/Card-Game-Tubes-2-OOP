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

import com.avatarduel.model.*;
import com.avatarduel.util.CSVReader;
import com.avatarduel.gui.RegView;

public class AvatarDuel extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";

  Stage window;
  Scene one,two;

  public void loadCards() throws IOException, URISyntaxException {
    File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
    CSVReader landReader = new CSVReader(landCSVFile, "\t");
    landReader.setSkipHeader(true);
    List<String[]> landRows = landReader.read();
    for (String[] row : landRows) {
      // Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
    }
  }

  @Override
  public void start(Stage stage) throws IOException {
    RegView.loadRegScreen(this);
    Scene scene = new Scene(RegView.Screen);

    stage.setTitle("Avatar Card Game");
    stage.setScene(scene);
    stage.show();

    // Parent window = null;
    // try{
    // Parent window = FXMLLoader.load(getClass().getResource("com/gui/RegisterUI.fxml"));
    // }catch (Exception E){
    //   System.out.println(E);
    // }
    // Scene windowSc = new Scene(window,500,500);
    // Group window = loader.load(getClass().getResource("RegisterUI.fxml"));
    // stage.setTitle("Avatar Card Game");
    // stage.getIcons().add(new Image("com/bae.jpg"));
    // stage.setScene(windowSc);
    // stage.show();
    // Text text = new Text();
    // text.setText("Loading...");
    // text.setX(50);
    // text.setY(50);
    // Group root = new Group();
    // root.getChildren().add(text);

    // Scene scene = new Scene(root, 1280, 720);

    // stage.setTitle("Avatar Duel");
    // stage.setScene(windowSc);
    // stage.show();

    // try {
    //   this.loadCards();
    //   text.setText("Avatar Duel!");
    // } catch (Exception e) {
    //   text.setText("Failed to load cards: " + e);
    // }
  }

  public static void main(String[] args) {
    Application.launch();
  }
}