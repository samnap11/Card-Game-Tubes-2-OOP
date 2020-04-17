package com.avatarduel.card;

import com.avatarduel.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CardLoader {
    public ArrayList<Card> ret;
    private static final String LAND_CSV_FILE_PATH = "src/main/resources/com/avatarduel/card/data/land.csv";
    private static final String CHARACTER_CSV_FILE_PATH = "src/main/resources/com/avatarduel/card/data/character.csv";
    private static final String SKILL_CSV_FILE_PATH = "com/avatarduel/card/data/skill.csv";

    public CardLoader() {
        ret = new ArrayList<>();
    }
    public ArrayList<Card> loadCards() throws IOException, URISyntaxException {
        // ret = new ArrayList<>();
        // ret.clear();
        loadLands();
        loadCharacters();
        // loadSkills();
        return ret;
    }
    public void loadLands() throws IOException, URISyntaxException {
        try{
            // System.out.println("Working Directory = " + System.getProperty("user.dir"));
            File landCSVFile = new File(LAND_CSV_FILE_PATH);
            CSVReader landReader = new CSVReader(landCSVFile,"\t");
            landReader.setSkipHeader(true);
            List<String[]> landRows = landReader.read();
            for(String[] rows: landRows) {
                // System.out.println(rows.length);

                if (rows.length > 2){
                    Land land = new Land(rows[1], rows[3], Element.valueOf(rows[2]),rows[4] ,Integer.parseInt(rows[5]));
                    ret.add(land);
                }
            }
        }catch(Exception E){
            // System.out.println(E);
            // System.out.println("hai");
        }
        // System.out.printf("Haalo");
        
    }
    public void loadCharacters() throws IOException, URISyntaxException {
        File characterCSVFile = new File(CHARACTER_CSV_FILE_PATH);
        CSVReader characterReader = new CSVReader(characterCSVFile,"\t");
        characterReader.setSkipHeader(true);
        List<String[]> characterRows = characterReader.read();
        for(String[] rows: characterRows) {
            // System.out.println(rows.length);
            if (rows.length > 2){
                Character character = new Character(rows[1],rows[3],Element.valueOf(rows[2]),rows[4],Integer.parseInt(rows[5]),Integer.parseInt(rows[6]),Integer.parseInt(rows[7]));
                ret.add(character);
            }
        }
    }
    public static void loadSkills() {
        loadAura();
        loadPowerUp();
        loadDestroy();
    }
    public static void loadAura() {

    }
    public  static void loadPowerUp() {

    }
    public  static void loadDestroy() {

    }
}
