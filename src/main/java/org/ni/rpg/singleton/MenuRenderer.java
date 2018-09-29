package org.ni.rpg.singleton;

import org.ni.rpg.entity.Frame;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.utils.Config;

import java.util.stream.Stream;

import static org.ni.rpg.enums.ColorCode.ANSI_RED;
import static org.ni.rpg.enums.ColorCode.ANSI_RESET;

/**
 * Created by nazmul on 9/29/2018.
 */
public class MenuRenderer {
    private static final MenuRenderer instance = new MenuRenderer();

    private MenuRenderer(){}

    public static MenuRenderer getInstance(){
        return instance;
    }

    public void showStartMenu() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame welcomeMessage = new Frame("Welcome to cli-battleground");
        welcomeMessage.drawBorder();
        Frame instructionFrame = new Frame(20,20);
        Frame pressInstruction1 = new Frame("Press 1 to Start");
        Frame pressInstruction2 = new Frame("Press 3 to Exit");
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction2).toArray(Frame[]::new));
        mainFrame.drawMiddle(Stream.of(welcomeMessage,instructionFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void showStartMenuAnim() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame welcomeMessage = new Frame(ANSI_RED.getColorCode() + "Welcome to cli-battleground" + ANSI_RESET.getColorCode());
        welcomeMessage.drawBorder();
        Frame instructionFrame = new Frame(20,20);
        Frame pressInstruction1 = new Frame("Press 1 to Start");
        Frame pressInstruction2 = new Frame("Press 3 to Exit");
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction2).toArray(Frame[]::new));
        mainFrame.drawMiddle(Stream.of(welcomeMessage,instructionFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void showThanksMenu() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame goodbyeFrame = new Frame("Thank You");
        goodbyeFrame.drawBorder();
        mainFrame.drawMiddle(goodbyeFrame.getContent());
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void showPlayerCreationMenuName() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame nameAskingFrame = new Frame("Provide your name please:");
        mainFrame.drawMiddle(nameAskingFrame.getContent());
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void showPlayerCreationMenuInfo(String name) throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame nameFrame = new Frame("Player Name:"+name);
        Frame infoFrame = new Frame("Provide description please:");
        nameFrame.drawBorder();
        mainFrame.drawMiddle(Stream.of(nameFrame,infoFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void showGameStarterScreen(String name) throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame line1 = new Frame("Enemies ahead....");
        Frame line2 = new Frame(name+", kill them all....");
        line2.drawBorder();
        mainFrame.drawMiddle(Stream.of(line1,line2).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void showPlayPauseMenu(String name) throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame message = new Frame("Hope you are enjoying.");
        message.drawBorder();
        Frame instructionFrame = new Frame(20,20);
        Frame pressInstruction1 = new Frame("Press 1 to Resume");
        Frame pressInstruction2 = new Frame("Press 2 to main menu");
        Frame pressInstruction3 = new Frame("Press 3 to Exit");
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction2,pressInstruction3).toArray(Frame[]::new));
        instructionFrame.drawBorder();
        mainFrame.drawMiddle(Stream.of(message,instructionFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void showPauseMenu(Character[][] content) throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        mainFrame.drawMiddle(content);
        mainFrame.drawBorder();
        Frame message = new Frame("Want to save the game.");
        message.drawBorder();
        Frame instructionFrame = new Frame(23,20);
        Frame pressInstruction1 = new Frame("Press 1 to Return");
        Frame pressInstruction2 = new Frame("Press 2 to Save");
        Frame pressInstruction3 = new Frame("Press 3 to Main menu");
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction2,pressInstruction3).toArray(Frame[]::new));
        mainFrame.drawMiddle(Stream.of(message,instructionFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }
}
