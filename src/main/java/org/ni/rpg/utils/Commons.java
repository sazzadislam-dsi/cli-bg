package org.ni.rpg.utils;

import org.ni.rpg.entity.Dimension;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Commons {
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
}
