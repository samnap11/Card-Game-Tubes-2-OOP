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
    private static final String AURA_CSV_FILE_PATH = "card/data/aura.csv";
    private static final String DESTROY_CSV_FILE_PATH = "card/data/destroy.csv";
    private static final String POWERUP_CSV_FILE_PATH = "card/data/powerup.csv";

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
            Land land = new Land(rows[1], rows[3], Element.valueOf(rows[2]),rows[4] ,Integer.parseInt(rows[5]));
            ret.add(land);
        }
    }
    public void loadCharacters() throws IOException, URISyntaxException {
        File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
        CSVReader characterReader = new CSVReader(characterCSVFile,"\t");
        characterReader.setSkipHeader(true);
        List<String[]> characterRows = characterReader.read();
        for(String[] rows: characterRows) {
            Character character = new Character(rows[1],rows[3],Element.valueOf(rows[2]),rows[4],Integer.parseInt(rows[5]),Integer.parseInt(rows[6]),Integer.parseInt(rows[7]));
            ret.add(character);
        }
    }
    public void loadSkills() throws IOException, URISyntaxException {
        loadAura();
        loadPowerUp();
        loadDestroy();
    }
    public void loadAura() throws IOException, URISyntaxException {
        File auraCSVFile = new File(getClass().getResource(AURA_CSV_FILE_PATH).toURI());
        CSVReader auraReader = new CSVReader(auraCSVFile,"\t");
        auraReader.setSkipHeader(true);
        List<String[]> auraRows = auraReader.read();
        for(String[] rows: auraRows) {
            Aura aura = new Aura(rows[1],rows[3],Element.valueOf(rows[2]),rows[4],Integer.parseInt(rows[5]),Integer.parseInt(rows[6]),Integer.parseInt(rows[7]));
            ret.add(aura);
        }
    }
    public  void loadPowerUp() throws IOException, URISyntaxException {
        File powerUpCSVFile = new File(getClass().getResource(POWERUP_CSV_FILE_PATH).toURI());
        CSVReader powerUpReader = new CSVReader(powerUpCSVFile,"\t");
        powerUpReader.setSkipHeader(true);
        List<String[]> powerUpRows = powerUpReader.read();
        for(String[] rows: powerUpRows) {
            PowerUp powerUp = new PowerUp(rows[1],rows[3],Element.valueOf(rows[2]),rows[4],Integer.parseInt(rows[5]));
            ret.add(powerUp);
        }
    }
    public  void loadDestroy() throws IOException, URISyntaxException {
        File destroyCSVFile = new File(getClass().getResource(DESTROY_CSV_FILE_PATH).toURI());
        CSVReader destroyReader = new CSVReader(destroyCSVFile,"\t");
        destroyReader.setSkipHeader(true);
        List<String[]> destroyRows = destroyReader.read();
        for(String[] rows: destroyRows) {
            Destroy destroy = new Destroy(rows[1],rows[3],Element.valueOf(rows[2]),rows[4],Integer.parseInt(rows[5]));
            ret.add(destroy);
        }
    }
}
