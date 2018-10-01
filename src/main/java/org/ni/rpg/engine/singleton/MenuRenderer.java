package org.ni.rpg.engine.singleton;

import org.ni.rpg.core.enitiy.Frame;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.utils.Commons;
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
        Frame instructionFrame = new Frame(22,10);
        Frame pressInstruction1 = new Frame("Press 1 to Start",true);
        Frame pressInstruction2 = new Frame("Press 2 to Resume",true);
        Frame pressInstruction3 = new Frame("Press 3 to Exit",true);
        Frame keyPressSuggestion = new Frame("After taping any word. press enter.",true);
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction2,pressInstruction3).toArray(Frame[]::new));
        mainFrame.drawMiddle(Stream.of(welcomeMessage,instructionFrame,keyPressSuggestion).toArray(Frame[]::new));
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

    public void showPlayerCreationMenuWeapon() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame nameFrame = new Frame("Player Name:"+ Commons.getPlayerName());
        Frame infoFrame = new Frame("Choose your weapon:");
        Frame weaponFrame = new Frame(30,20);
        Frame weaponFrame1 = new Frame("Press 1 - UZI (A-12,R-3)",true);
        Frame weaponFrame2 = new Frame("Press 2 - AKM (A-10,R-4)",true);
        Frame weaponFrame3 = new Frame("Press 3 - AWM (A-7,R-5)",true);
        weaponFrame.drawMiddle(Stream.of(weaponFrame1,weaponFrame2,weaponFrame3).toArray(Frame[]::new));
        mainFrame.drawMiddle(Stream.of(nameFrame,infoFrame,weaponFrame).toArray(Frame[]::new));
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

    public void showNoSaveFileMenu() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame message = new Frame("No save file found or save file not compatible.");
        message.drawBorder();
        Frame instructionFrame = new Frame(20,20);
        Frame pressInstruction1 = new Frame("Press 1 to Start");
        Frame pressInstruction3 = new Frame("Press 3 to Exit");
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction3).toArray(Frame[]::new));
        instructionFrame.drawBorder();
        mainFrame.drawMiddle(Stream.of(message,instructionFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void inGameHelpMenu() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame message = new Frame("Help");
        message.drawBorder();
        Frame instructionFrame = new Frame(20,20);
        Frame pressInstruction1 = new Frame("Direction/Control",true);
        Frame pressInstruction2 = new Frame("UP - w",true);
        Frame pressInstruction3 = new Frame("DOWN - s",true);
        Frame pressInstruction4 = new Frame("LEFT - a",true);
        Frame pressInstruction5 = new Frame("RIGHT - d",true);
        Frame pressInstruction10 = new Frame("FIRE - f",true);
        Frame pressInstruction6 = new Frame("HELP - h",true);
        Frame pressInstruction7 = new Frame("START - 1",true);
        Frame pressInstruction8 = new Frame("SAVE - 2",true);
        Frame pressInstruction9 = new Frame("Main Menu - 3",true);
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction2,
                pressInstruction3,pressInstruction4,pressInstruction5,pressInstruction10,
                pressInstruction6,pressInstruction7,pressInstruction8,pressInstruction9).toArray(Frame[]::new));
        instructionFrame.drawBorder();
        mainFrame.drawMiddle(Stream.of(message,instructionFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void showGameOverMenu() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame message = new Frame("Better luck next time.");
        message.drawBorder();
        Frame instructionFrame = new Frame(20,20);
        Frame pressInstruction1 = new Frame("Press 1 to Start");
        Frame pressInstruction3 = new Frame("Press 3 to Exit");
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction3).toArray(Frame[]::new));
        instructionFrame.drawBorder();
        mainFrame.drawMiddle(Stream.of(message,instructionFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void showVictoryMenu() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame message = new Frame("Congratulation.");
        message.drawBorder();
        Frame instructionFrame = new Frame(20,20);
        Frame pressInstruction1 = new Frame("Press 1 to Start");
        Frame pressInstruction3 = new Frame("Press 3 to Exit");
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction3).toArray(Frame[]::new));
        instructionFrame.drawBorder();
        mainFrame.drawMiddle(Stream.of(message,instructionFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }

    public void showGameStartMenu() throws FrameSizeOutOfBound {
        Frame mainFrame = new Frame(Config.MAX_WIDTH,Config.MAX_HEIGHT);
        Frame message = new Frame("Instruction -");
        message.drawBorder();
        Frame instructionFrame = new Frame(85,20);
        Frame pressInstruction1 = new Frame("Welcome 1st cli base battle royal game.",true);
        Frame pressInstruction2 = new Frame("You are about to enter into the shooting area " +
                                                       "with "+Config.AI_PLAYER+" players.",true);
        Frame pressInstruction3 = new Frame("You need to survive to win the game " +
                                                        "and kill other players.",true);
        Frame pressInstruction4 = new Frame("Use 'w','s','a','d' to move up down " +
                                                        "left right and press 'f' to shoot other player.",true);
        Frame pressInstruction5 = new Frame("You can pause anytime in the " +
                                                        "game and resume.",true);
        Frame pressInstruction6 = new Frame("Please save the game if you want to play " +
                                                        "where you left off. Best of luck!",true);
        Frame pressInstruction7 = new Frame("P - Player, E - Enemy, T - Tree, (-) " +
                                                        "Indicating yous gun point.",true);
        Frame pressInstruction8 = new Frame("Press 1 to Continue");
        instructionFrame.drawMiddle(Stream.of(pressInstruction1,pressInstruction2,
                pressInstruction3,pressInstruction4,pressInstruction5,pressInstruction6,
                pressInstruction7,pressInstruction8).toArray(Frame[]::new));
        instructionFrame.drawBorder();
        mainFrame.drawMiddle(Stream.of(message,instructionFrame).toArray(Frame[]::new));
        System.out.println(mainFrame.getFrameForPrint());
    }
}
