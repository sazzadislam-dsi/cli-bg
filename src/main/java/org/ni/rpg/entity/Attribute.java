package org.ni.rpg.entity;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Attribute {
    boolean canMove;
    boolean visible;
    boolean goThrough;
    boolean takeDamage;
    boolean canBeKilled;
    boolean killed;
    boolean removeAfterKilled;

    public Attribute(boolean canMove, boolean visible, boolean goThrough, boolean takeDamage, boolean canBeKilled, boolean killed, boolean removeAfterKilled) {
        this.canMove = canMove;
        this.visible = visible;
        this.goThrough = goThrough;
        this.takeDamage = takeDamage;
        this.canBeKilled = canBeKilled;
        this.killed = killed;
        this.removeAfterKilled = removeAfterKilled;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isGoThrough() {
        return goThrough;
    }

    public void setGoThrough(boolean goThrough) {
        this.goThrough = goThrough;
    }

    public boolean isTakeDamage() {
        return takeDamage;
    }

    public void setTakeDamage(boolean takeDamage) {
        this.takeDamage = takeDamage;
    }

    public boolean isCanBeKilled() {
        return canBeKilled;
    }

    public void setCanBeKilled(boolean canBeKilled) {
        this.canBeKilled = canBeKilled;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isRemoveAfterKilled() {
        return removeAfterKilled;
    }

    public void setRemoveAfterKilled(boolean removeAfterKilled) {
        this.removeAfterKilled = removeAfterKilled;
    }
}
