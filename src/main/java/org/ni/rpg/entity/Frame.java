package org.ni.rpg.entity;

import org.ni.rpg.utils.Commons;
import org.ni.rpg.utils.Config;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Frame {
    int WIDTH = -1;
    int HEIGHT = -1;
    int frameRate = 10;
    private Character[][] content;

    public Frame() {
        this(Config.MAX_WIDTH,Config.MAX_HEIGHT);
    }

    public Frame(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        content = new Character[HEIGHT][WIDTH];
        clean();
    }
    public void drawBorder() {
        for(int i=0;i<HEIGHT;i++){
            for(int j=0;j<WIDTH;j++){
                if(j == 0 || j == WIDTH-1){
                    content[i][j] = '_';
                }else if(i == 0 || i == HEIGHT-1){
                    content[i][j] = '|';
                }
            }
        }
    }


    public void clean() {
        for(int i=0;i<HEIGHT;i++){
            for(int j=0;j<WIDTH;j++){
                content[i][j] = ' ';
            }
        }
    }

    public void drawMiddle(String string) {
        char[] stringToCharArray = string.toCharArray();
        int startWidth = WIDTH/2-stringToCharArray.length/2;
        int startHeight = HEIGHT/2-stringToCharArray.length/2;
        for(int i = 0; i < stringToCharArray.length; i++){
            content[startHeight][startWidth]=stringToCharArray[i];
            startWidth++;
        }
    }

    public void drawMiddle(Character[][] characters) {
        drawAtPosition(WIDTH/2,HEIGHT/2,characters);
    }

    public void drawAtPosition(int positionX, int positionY, Character[][] characters) {
        int startHeight = positionY-characters.length/2;
        for(int i = 0; i < characters.length; i++){
            int startWidth = positionX-characters[i].length/2;
            for(int j=0;j<characters[i].length;j++){
                content[startHeight][startWidth]= characters[i][j];
                startWidth++;
            }
            startHeight++;
        }
    }

    public String getFrameForPrint(){
        StringBuffer forPrint = new StringBuffer();
        for(int i=0;i<HEIGHT;i++){
            String line = Arrays.stream(content[i]).map(Object::toString).collect( Collectors.joining() );
            forPrint.append(line).append("\n");
        }
        return forPrint.toString();
    }

}
