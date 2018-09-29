package org.ni.rpg.composite;

import org.ni.rpg.entity.Appearance;
import org.ni.rpg.entity.Attribute;
import org.ni.rpg.exception.FrameSizeOutOfBound;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by nazmul on 9/28/2018.
 */
public abstract class GameObject implements Serializable {

    private String id;
    private Appearance appearance;
    private Attribute attribute;

    public abstract Character[][] draw(Character[][] characters) throws FrameSizeOutOfBound;

    public GameObject(Appearance appearance, Attribute attribute) {
        id = UUID.randomUUID().toString();
        this.appearance = appearance;
        this.attribute = attribute;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    /*@Override
    public int compareTo(GameObject gameObject) {
        return Integer.compare(appearance.getPositionX(),gameObject.getAppearance().getPositionX());
    }*/
}
