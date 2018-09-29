package org.ni.rpg.singleton;

import org.ni.rpg.entity.Frame;
import org.ni.rpg.exception.FrameSizeOutOfBound;

import java.util.stream.Stream;

/**
 * Created by nazmul on 9/29/2018.
 */
public class MenuEngine {
    private static final MenuEngine instance = new MenuEngine();

    private MenuEngine(){}

    public static MenuEngine getInstance(){
        return instance;
    }

    public void showStartMenu() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(100,50);
        Frame welcomeMessage = new Frame("Welcome to cli-battleground");
        welcomeMessage.drawBorder();
        Frame instructionFrame = new Frame(20,20);
        Frame pressInstruction1 = new Frame("Press 1 to Start");
        Frame pressInstruction2 = new Frame("Press 3 to Exit");
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction2).toArray(Frame[]::new));
        mainFrame.drawMiddle(Stream.of(welcomeMessage,instructionFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }
}
