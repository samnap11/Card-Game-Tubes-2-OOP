package com.avatarduel.card;

import com.avatarduel.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CardLoader {
    public static ArrayList<Card> ret;
    private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
    private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
    private static final String SKILL_CSV_FILE_PATH = "card/data/skill.csv";

    public CardLoader() {
        ret = new ArrayList<>();
    }
    public ArrayList<Card> loadCards() throws IOException, URISyntaxException {
        loadLands();
        loadCharacters();
        loadSkills();
        return ret;
    }
    public void loadLands() throws IOException, URISyntaxException {
        File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
        CSVReader landReader = new CSVReader(landCSVFile,"\t");
        landReader.setSkipHeader(true);
        List<String[]> landRows = landReader.read();
        for(String[] rows: landRows) {
            Land land = new Land(rows[1], rows[3], Element.valueOf(rows[2]), Integer.parseInt(rows[5]));
            ret.add(land);
        }
    }
    public void loadCharacters() throws IOException, URISyntaxException {
        File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
        CSVReader characterReader = new CSVReader(characterCSVFile,"\t");
        characterReader.setSkipHeader(true);
        List<String[]> characterRows = characterReader.read();
        for(String[] rows: characterRows) {
            Character character = new Character(rows[1],rows[3],Element.valueOf(rows[2]),Integer.parseInt(rows[5]),Integer.parseInt(rows[6]),Integer.parseInt(rows[7]));
            ret.add(character);
        }
    }
    public void loadSkills() {
        loadAura();
        loadPowerUp();
        loadDestroy();
    }
    public void loadAura() {

    }
    public  void loadPowerUp() {

    }
    public  void loadDestroy() {

    }
}
