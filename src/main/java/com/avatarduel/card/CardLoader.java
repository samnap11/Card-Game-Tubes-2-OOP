package com.avatarduel.card;

import com.avatarduel.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CardLoader {
    public static ArrayList<Card> ret;
    private static final String LAND_CSV_FILE_PATH = "src/main/resources/com/avatarduel/card/data/land.csv";
    private static final String CHARACTER_CSV_FILE_PATH = "src/main/resources/com/avatarduel/card/data/character.csv";
    private static final String AURA_CSV_FILE_PATH = "src/main/resources/com/avatarduel/card/data/aura.csv";
    private static final String DESTROY_CSV_FILE_PATH = "src/main/resources/com/avatarduel/card/data/destroy.csv";
    private static final String POWERUP_CSV_FILE_PATH = "src/main/resources/com/avatarduel/card/data/powerup.csv";

    /**
     * Create an arraylist for the cards which will be loaded
     */
    public CardLoader() {
        ret = new ArrayList<>();
    }

    /**
     * Load all of the cards to an arraylist
     * @return the list of all the cards which had been loaded
     * @throws IOException
     * @throws URISyntaxException
     */
    public ArrayList<Card> loadCards() throws IOException, URISyntaxException {
        ret = new ArrayList<>();
        loadLands();
        loadCharacters();
        loadSkills();
        Collections.shuffle(ret);
        Collections.shuffle(ret);
        Collections.shuffle(ret);
        return ret;
    }

    /**
     * Load land cards to the arraylist
     * @throws IOException
     * @throws URISyntaxException
     */
    public void loadLands() throws IOException, URISyntaxException {
        try{
            File landCSVFile = new File(LAND_CSV_FILE_PATH);
            CSVReader landReader = new CSVReader(landCSVFile,"\t");
            landReader.setSkipHeader(true);
            List<String[]> landRows = landReader.read();
            for(String[] rows: landRows) {
                Land land = new Land(rows[1], rows[3], Element.valueOf(rows[2]),rows[4] ,Integer.parseInt(rows[5]));
                ret.add(land);
            }
        }
        catch (Exception E){
            System.out.println(E);
        }
    }

    /**
     * Load character cards to the arraylist
     * @throws IOException
     * @throws URISyntaxException
     */
    public void loadCharacters() throws IOException, URISyntaxException {
        File characterCSVFile = new File(CHARACTER_CSV_FILE_PATH);
        CSVReader characterReader = new CSVReader(characterCSVFile,"\t");
        characterReader.setSkipHeader(true);
        List<String[]> characterRows = characterReader.read();
        for(String[] rows: characterRows) {
            Character character = new Character(rows[1],rows[3],Element.valueOf(rows[2]),rows[4],Integer.parseInt(rows[5]),Integer.parseInt(rows[6]),Integer.parseInt(rows[7]));
            ret.add(character);
        }
    }

    /**
     * Load skill cards to the arraylist
     * @throws IOException
     * @throws URISyntaxException
     */
    public void loadSkills() throws IOException, URISyntaxException {
        loadAura();
        loadPowerUp();
        loadDestroy();
    }

    /**
     * Load aura cards to the arraylist
     * @throws IOException
     * @throws URISyntaxException
     */
    public void loadAura() throws IOException, URISyntaxException {
        File auraCSVFile = new File(AURA_CSV_FILE_PATH);
        CSVReader auraReader = new CSVReader(auraCSVFile,"\t");
        auraReader.setSkipHeader(true);
        List<String[]> auraRows = auraReader.read();
        for(String[] rows: auraRows) {
            Aura aura = new Aura(rows[1],rows[3],Element.valueOf(rows[2]),rows[4],Integer.parseInt(rows[5]),Integer.parseInt(rows[6]),Integer.parseInt(rows[7]));
            ret.add(aura);
        }
    }

    /**
     * Load power up cards to the arraylist
     * @throws IOException
     * @throws URISyntaxException
     */
    public  void loadPowerUp() throws IOException, URISyntaxException {
        File powerUpCSVFile = new File(POWERUP_CSV_FILE_PATH);
        CSVReader powerUpReader = new CSVReader(powerUpCSVFile,"\t");
        powerUpReader.setSkipHeader(true);
        List<String[]> powerUpRows = powerUpReader.read();
        for(String[] rows: powerUpRows) {
            PowerUp powerUp = new PowerUp(rows[1],rows[3],Element.valueOf(rows[2]),rows[4],Integer.parseInt(rows[5]));
            ret.add(powerUp);
        }
    }

    /**
     * Load destroy cards to the arraylist
     * @throws IOException
     * @throws URISyntaxException
     */
    public  void loadDestroy() throws IOException, URISyntaxException {
        File destroyCSVFile = new File(DESTROY_CSV_FILE_PATH);
        CSVReader destroyReader = new CSVReader(destroyCSVFile,"\t");
        destroyReader.setSkipHeader(true);
        List<String[]> destroyRows = destroyReader.read();
        for(String[] rows: destroyRows) {
            Destroy destroy = new Destroy(rows[1],rows[3],Element.valueOf(rows[2]),rows[4],Integer.parseInt(rows[5]));
            ret.add(destroy);
        }
    }
}
