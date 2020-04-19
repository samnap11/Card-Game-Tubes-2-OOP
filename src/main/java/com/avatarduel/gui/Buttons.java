package com.avatarduel.gui;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;

// import com.avatarduel.gui.FieldG;
import com.avatarduel.state.State;
import com.avatarduel.state.Phase;

public class Buttons{
    private static Button drawPhaseButton = new Button("Draw");
    private static Button main1PhaseButton = new Button("Main 1");
    private static Button battlePhaseButton = new Button("Battle");
    private static Button main2PhaseButton = new Button("Main 2");
    private static Button endPhaseButton = new Button("End");
    
    
    public static VBox phaseButtons(){
        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(drawPhaseButton);
        buttonBox.getChildren().add(main1PhaseButton);
        buttonBox.getChildren().add(battlePhaseButton);
        // buttonBox.getChildren().add(main2PhaseButton);
        buttonBox.getChildren().add(endPhaseButton);
        return buttonBox;
    }

    public static void init(){
        drawPhaseButton.setDisable(true);
        main1PhaseButton.setDisable(true);
        battlePhaseButton.setDisable(false);
        // main2PhaseButton.setDisable(true);
        endPhaseButton.setDisable(true);
        main1PhaseButton.setOnAction(e -> nextPhase(main1PhaseButton,battlePhaseButton));
        battlePhaseButton.setOnAction(e -> nextPhase(battlePhaseButton,endPhaseButton));
        // main2.setOnAction(e -> enterNextPhase(main2, end, "Main Phase 2"));
        endPhaseButton.setOnAction(e -> State.endTurn());
    }

    public static void nextPhase(Button now, Button next){
        State.nextPhase();
        now.setDisable(true);
        next.setDisable(false);
    }
}