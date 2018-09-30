package org.ni.rpg.strategy.impl;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.entity.Dimension;
import org.ni.rpg.entity.Player;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.singleton.GameController;
import org.ni.rpg.strategy.DrawStrategy;
import org.ni.rpg.utils.Commons;

import java.io.Serializable;

/**
 * Created by nazmul on 9/29/2018.
 */
public class PlayerDrawStrategy implements DrawStrategy,Serializable {
    private static final long serialversionUID = 538219549L;

    @Override
    public Character[][] draw(Character[][] content, GameObject gameObject) throws FrameSizeOutOfBound {
        if((gameObject.getAppearance().isVisible() || !gameObject.getAttribute().isKilled() || (gameObject.getAttribute().isKilled()&&!gameObject.getAttribute().isRemoveAfterKilled())) && gameObject.getAppearance().getDimension().getWidth() > 0 && gameObject.getAppearance().getDimension().getHeight() > 0){
            int startHeight = gameObject.getAppearance().getPositionY();
            Dimension dimension = Commons.calculateDimension(content);
            if(gameObject.getAppearance().getPositionX() < 0 || gameObject.getAppearance().getPositionY() < 0 || gameObject.getAppearance().getPositionY() + gameObject.getAppearance().getDimension().getHeight() > dimension.getHeight() || ( gameObject.getAppearance().getDimension().getWidth() + gameObject.getAppearance().getPositionX() > dimension.getWidth())){
                throw new FrameSizeOutOfBound();
            }
            for(int i = 0; i < gameObject.getAppearance().getContent().length; i++){
                int startWidth = gameObject.getAppearance().getPositionX();
                for(int j=0;j<gameObject.getAppearance().getContent().length;j++){
                    content[startHeight][startWidth]= gameObject.getAppearance().getContent()[i][j];
                    startWidth++;
                }
                startHeight++;
            }
            if(gameObject.getAppearance().getDirection().equals(GameController.UP)){
                if(gameObject.getAppearance().getPositionY()>0){
                    content[gameObject.getAppearance().getPositionY()-1][gameObject.getAppearance().getPositionX()] = '|';
                }
                getStatus(gameObject,dimension,content);
            }else if(gameObject.getAppearance().getDirection().equals(GameController.DOWN)){
                if(gameObject.getAppearance().getPositionY()+gameObject.getAppearance().getDimension().getHeight()<dimension.getHeight()){
                    content[gameObject.getAppearance().getPositionY()+gameObject.getAppearance().getDimension().getHeight()][gameObject.getAppearance().getPositionX()+1] = '|';
                }
                getStatus(gameObject,dimension,content);
            }else if(gameObject.getAppearance().getDirection().equals(GameController.LEFT)){
                if(gameObject.getAppearance().getPositionX()>0){
                    content[gameObject.getAppearance().getPositionY()][gameObject.getAppearance().getPositionX()-1] = '-';
                }
                getStatus(gameObject,dimension,content);
            }else if(gameObject.getAppearance().getDirection().equals(GameController.RIGHT)){
                if(gameObject.getAppearance().getPositionX()+gameObject.getAppearance().getDimension().getWidth()<dimension.getWidth()){
                    content[gameObject.getAppearance().getPositionY()][gameObject.getAppearance().getPositionX()+gameObject.getAppearance().getDimension().getWidth()+1] = '-';
                }
                getStatus(gameObject,dimension,content);
            }


        }
        return content;
    }

    private void getStatus(GameObject gameObject, Dimension dimension, Character[][] content){
        String status = "";
        if(gameObject instanceof Player){
            Player player = (Player)gameObject;
            status = Commons.getStatusLine(player);
        }
        if(!Commons.isEmpty(status) && gameObject.getAppearance().getPositionY()>1){
            int startY = gameObject.getAppearance().getPositionY()-2;
            char[] statusCharArr = status.toCharArray();
            int statusLengthHalf = statusCharArr.length/2;
            int startX = 0;
            if(gameObject.getAppearance().getPositionX()-statusLengthHalf>=0){
                startX = gameObject.getAppearance().getPositionX() - statusLengthHalf;
            }
            try {
                for (int i = 0; i < statusCharArr.length; i++) {
                    if (content[startY][startX].equals(' ')) {
                        content[startY][startX] = statusCharArr[i];
                    }
                    startX++;
                    if (startX >= dimension.getWidth()) {
                        break;
                    }
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }
}
