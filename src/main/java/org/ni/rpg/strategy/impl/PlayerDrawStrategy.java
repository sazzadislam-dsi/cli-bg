package org.ni.rpg.strategy.impl;

import org.ni.rpg.entity.Appearance;
import org.ni.rpg.entity.Attribute;
import org.ni.rpg.entity.Dimension;
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
    public Character[][] draw(Character[][] content, Appearance appearance, Attribute attribute) throws FrameSizeOutOfBound {
        if((appearance.isVisible() || !attribute.isKilled() || (attribute.isKilled()&&!attribute.isRemoveAfterKilled())) && appearance.getDimension().getWidth() > 0 && appearance.getDimension().getHeight() > 0){
            int startHeight = appearance.getPositionY();
            Dimension dimension = Commons.calculateDimension(content);
            if(appearance.getPositionX() < 0 || appearance.getPositionY() < 0 || appearance.getPositionY() + appearance.getDimension().getHeight() > dimension.getHeight() || ( appearance.getDimension().getWidth() + appearance.getPositionX() > dimension.getWidth())){
                throw new FrameSizeOutOfBound();
            }
            for(int i = 0; i < appearance.getContent().length; i++){
                int startWidth = appearance.getPositionX();
                for(int j=0;j<appearance.getContent().length;j++){
                    content[startHeight][startWidth]= appearance.getContent()[i][j];
                    startWidth++;
                }
                startHeight++;
            }
            if(appearance.getDirection().equals(GameController.UP)){
                if(appearance.getPositionY()>0){
                    content[appearance.getPositionY()-1][appearance.getPositionX()] = '|';
                }
            }else if(appearance.getDirection().equals(GameController.DOWN)){
                if(appearance.getPositionY()+appearance.getDimension().getHeight()<dimension.getHeight()){
                    content[appearance.getPositionY()+appearance.getDimension().getHeight()][appearance.getPositionX()+1] = '|';
                }
            }else if(appearance.getDirection().equals(GameController.LEFT)){
                if(appearance.getPositionX()>0){
                    content[appearance.getPositionY()][appearance.getPositionX()-1] = '-';
                }
            }else if(appearance.getDirection().equals(GameController.RIGHT)){
                if(appearance.getPositionX()+appearance.getDimension().getWidth()<dimension.getWidth()){
                    content[appearance.getPositionY()][appearance.getPositionX()+appearance.getDimension().getWidth()+1] = '-';
                }
            }
        }
        return content;
    }
}
