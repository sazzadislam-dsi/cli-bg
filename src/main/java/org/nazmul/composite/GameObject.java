package org.nazmul.composite;

import org.nazmul.entity.Attribute;
import org.nazmul.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/28/2018.
 */
public abstract class GameObject{

    int positionX;
    int positionY;
    int height;
    int width;
    char[][] content;
    String color;
    Attribute attribute;

    public abstract char[][] draw(char[][] characters);

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char[][] getContent() {
        return content;
    }

    public void setContent(char[][] content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
