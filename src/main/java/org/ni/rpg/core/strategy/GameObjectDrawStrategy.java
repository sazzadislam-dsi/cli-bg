package org.ni.rpg.core.strategy;

import org.ni.rpg.core.composite.GameObject;
import org.ni.rpg.core.enitiy.Dimension;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.utils.Commons;

import java.io.Serializable;

/**
 * Created by nazmul on 9/29/2018.
 */
public class GameObjectDrawStrategy implements DrawStrategy,Serializable {
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
        }
        return content;
    }
}
