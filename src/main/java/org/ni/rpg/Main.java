package org.ni.rpg;

import org.ni.rpg.singleton.GameEngine;
import org.ni.rpg.exception.FrameSizeOutOfBound;


/**
 * Created by nazmul on 9/28/2018.
 */
public class Main {
    public static void main(String [] args) throws FrameSizeOutOfBound {
        try {
            GameEngine.getInstance().init();
        }catch (Exception ex){
            System.exit(1);
        }
    }
}
