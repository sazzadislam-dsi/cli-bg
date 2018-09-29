package org.ni.rpg.strategy.impl;

import org.ni.rpg.entity.Appearance;
import org.ni.rpg.entity.Attribute;
import org.ni.rpg.entity.Dimension;
import org.ni.rpg.entity.Frame;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.strategy.DrawStrategy;
import org.ni.rpg.utils.Commons;

/**
 * Created by nazmul on 9/29/2018.
 */
public class GameObjectDrawStrategy implements DrawStrategy {
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
        }
        return content;
    }
}
