package org.ni.rpg.entity;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Appearance {
    private int positionX;
    private int positionY;
    private Dimension dimension;
    private Character[][] content;
    private String color;
    private boolean visible;

    public Appearance(int positionX, int positionY, Dimension dimension, Character[][] content, String color, boolean visible) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.dimension = dimension;
        this.content = content;
        this.color = color;
        this.visible = visible;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Character[][] getContent() {
        return content;
    }

    public void setContent(Character[][] content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
