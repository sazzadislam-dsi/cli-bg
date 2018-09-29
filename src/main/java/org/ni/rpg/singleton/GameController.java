package org.ni.rpg.singleton;

import org.ni.rpg.enums.State;
import org.ni.rpg.exception.FrameSizeOutOfBound;

/**
 * Created by nazmul on 9/29/2018.
 */
public class GameController {
    private static GameController singleton = null;
    private GameEngine gameEngine;

    private static final String ONE="1";
    private static final String TWO="2";
    private static final String THREE="3";
    private static final String UP="w";
    private static final String LEFT="a";
    private static final String RIGHT="d";
    private static final String DOWN="s";

    public synchronized static GameController getInstance(GameEngine gameEngine) {
        if(singleton == null) singleton = new GameController(gameEngine);
        return singleton;
    }

    private GameController(GameEngine gameEngine){
        this.gameEngine = gameEngine;
    }

    public void actionOnKeyEvent(String givenInput) throws FrameSizeOutOfBound {
        if(gameEngine.getCURRENT_STATE().equals(State.MAIN_MENU)) {
            if(givenInput.equals(ONE)){
                gameEngine.playerCreationStart();
            }else if(givenInput.equals(THREE)){
                gameEngine.shutdown();
            }else{
                gameEngine.showStartMenu();
            }
        }else if(gameEngine.getCURRENT_STATE().equals(State.PLAYER_CREATION_NAME)) {
            if(givenInput.equals(THREE)){
                gameEngine.shutdown();
            }else if(givenInput.equals("")){
                gameEngine.playerCreationStart();
            }else{
                gameEngine.createGameState(givenInput);
            }
        }else if(gameEngine.getCURRENT_STATE().equals(State.GAME_PLAY)) {
            /*if(givenInput.equals(THREE)){
                gameEngine.gamePause();
            }else if(givenInput.equals(UP)){
                gameEngine.playerMoveUp();
            }else if(givenInput.equals(DOWN)){
                gameEngine.playerMoveDown();
            }else if(givenInput.equals(LEFT)){
                gameEngine.playerMoveLeft();
            }else if(givenInput.equals(RIGHT)){
                gameEngine.playerMoveRight();
            }else{
                gameEngine.generateFrame();
            }*/
        }
    }

}
