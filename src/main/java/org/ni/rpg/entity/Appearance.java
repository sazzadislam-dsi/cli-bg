package org.ni.rpg.entity;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Appearance {
    protected int positionX;
    protected int positionY;
    protected int height;
    protected int width;
    protected char[][] content;
    protected String color;

    public Appearance(int positionX, int positionY, int height, int width, char[][] content, String color) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.height = height;
        this.width = width;
        this.content = content;
        this.color = color;
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
}
