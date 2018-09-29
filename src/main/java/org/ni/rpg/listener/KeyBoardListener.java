package org.ni.rpg.listener;

import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.singleton.GameEngine;

import java.util.Scanner;

/**
 * Created by nazmul on 9/29/2018.
 */
public class KeyBoardListener {
    private static KeyBoardListener singleton = null;
    private GameEngine gameEngine;


    public synchronized static KeyBoardListener getInstance(GameEngine gameEngine) {
        if(singleton == null) singleton = new KeyBoardListener(gameEngine);
        return singleton;
    }


    private KeyBoardListener(GameEngine gameEngine){
        this.gameEngine = gameEngine;
    }

    public void listen() throws FrameSizeOutOfBound {
        while(true) {
            Scanner input=new Scanner(System.in);
            String givenInput = input.nextLine();
            gameEngine.registerKeyEvent(givenInput);
        }
    }
}
