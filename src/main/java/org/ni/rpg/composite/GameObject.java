package org.ni.rpg.composite;

import org.ni.rpg.entity.Appearance;
import org.ni.rpg.entity.Attribute;

/**
 * Created by nazmul on 9/28/2018.
 */
public abstract class GameObject{

    private Appearance appearance;
    private Attribute attribute;

    public abstract char[][] draw(char[][] characters);

    public GameObject(Appearance appearance, Attribute attribute) {
        this.appearance = appearance;
        this.attribute = attribute;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public abstract String getName();
}
