package com.avatarduel.gui;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;

// import com.avatarduel.gui.FieldG;
import com.avatarduel.state.State;
import com.avatarduel.state.Phase;


/**
 * Buttons hold the phase buttons, and sets event for each when clicked.
 *
 * @author saya
 */
public class Buttons{
    /**
     * The Instance of button for draw phase
     */
    private static Button drawPhaseButton = new Button("Draw");
    /**
     * The Instance of button for main phase
     */
    private static Button main1PhaseButton = new Button("Main 1");
    /**
     * The Instance of button for battle phase
     */
    private static Button battlePhaseButton = new Button("Battle");
    /**
     * The Instance of button for end turn
     */
    private static Button endPhaseButton = new Button("End");
    
    /**
     * @return Box conotaining all the Buttons
     */
    public static VBox phaseButtons(){
        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(drawPhaseButton);
        buttonBox.getChildren().add(main1PhaseButton);
        buttonBox.getChildren().add(battlePhaseButton);
        buttonBox.getChildren().add(endPhaseButton);
        return buttonBox;
    }

    /**
     * Initialize all the buttons event
     */
    public static void init(){
        drawPhaseButton.setDisable(true);
        main1PhaseButton.setDisable(true);
        battlePhaseButton.setDisable(false);
        endPhaseButton.setDisable(true);
        main1PhaseButton.setOnAction(e -> nextPhase(main1PhaseButton,battlePhaseButton));
        battlePhaseButton.setOnAction(e -> nextPhase(battlePhaseButton,endPhaseButton));
        endPhaseButton.setOnAction(e -> State.endTurn());
    }

    /**
     * change phase event of button clicked
     * @param now current turn, and pressed Button
     * @param next set to enable
     */
    public static void nextPhase(Button now, Button next){
        State.nextPhase();
        now.setDisable(true);
        next.setDisable(false);
    }
}