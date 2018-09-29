package org.ni.rpg.utils;

import org.ni.rpg.entity.Dimension;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Commons {
    private static String playerName = "";

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String name) {
        playerName = playerName;
    }

    public static Dimension calculateDimension(Character[][] content){
        int height = 0;
        int width = 0;
        for(Character[] row :content){
            height++;
            if(width<row.length){
                width = row.length;
            }
        }
        return new Dimension(height,width);
    }
    public static Character[][] generateGameStateContent(int height, int width) {
        Character[][] content = new Character[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                content[i][j] = ' ';
            }
        }
        return content;
    }
}
