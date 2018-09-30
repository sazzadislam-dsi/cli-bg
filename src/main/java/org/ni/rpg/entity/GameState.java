package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.singleton.GameController;
import org.ni.rpg.utils.Commons;
import org.ni.rpg.utils.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nazmul on 9/29/2018.
 */
public class GameState extends GameObject {
    private static final long serialversionUID = 538219554L;

    String playerId;

    ConcurrentHashMap<String, GameObject> gameObjects = new ConcurrentHashMap<>();

    public GameState(Appearance appearance, Attribute attribute) {
        super(appearance, attribute);
    }

    public void addGameObject(GameObject gameObject){
        gameObjects.put(gameObject.getId(),gameObject);
    }

    public void removeGameObject(GameObject gameObject){
        if(gameObjects.contains(gameObject.getId())){
            gameObjects.remove(gameObject.getId());
        }
    }

    public void removeGameObject(String gameObjectId){
        if(gameObjects.contains(gameObjectId)){
            gameObjects.remove(gameObjectId);
        }
    }

    public Character[][] draw(Character[][] characters) throws FrameSizeOutOfBound {
        characters = Commons.generateGameStateContent(getAppearance().getDimension().getHeight(),getAppearance().getDimension().getWidth());
        for(GameObject gameObject : gameObjects.values())
        {
            characters = gameObject.draw(characters);
        }
        return characters;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public GameObject getGameObjct(String key) {
        return gameObjects.get(key);
    }

    public List<Player> getMovableGameObject() {
        return gameObjects.values().stream()
                .filter(Player.class::isInstance )
                .filter( v -> v.getAttribute().isCanMove() )
                .filter( v -> !v.getId().equals(this.getPlayerId()) )
                .map( Player.class::cast )
                .collect(Collectors.toList() );
    }

    public List<Player> getKillAbleGameObject(int positionX, int positionY, String direction, int range, String ignoreId) {

        return gameObjects.values().stream()
                .filter(Player.class::isInstance )
                .filter( v -> v.getAttribute().isCanBeKilled() )
                .filter( v -> !v.getId().equals(ignoreId))
                .filter( v -> direction.equals(GameController.UP) && v.getAppearance().getPositionX() != positionX && v.getAppearance().getPositionY() > positionY && v.getAppearance().getPositionY() - range < positionY  )
                .filter( v -> direction.equals(GameController.DOWN) && v.getAppearance().getPositionX() != positionX && v.getAppearance().getPositionY() < positionY && v.getAppearance().getPositionY() + range > positionY  )
                .filter( v -> direction.equals(GameController.LEFT) && v.getAppearance().getPositionY() != positionY && v.getAppearance().getPositionX() > positionX && v.getAppearance().getPositionX() - range < positionX  )
                .filter( v -> direction.equals(GameController.RIGHT) && v.getAppearance().getPositionY() != positionY && v.getAppearance().getPositionX() < positionX && v.getAppearance().getPositionX() + range > positionX  )
                .map( Player.class::cast )
                .collect(Collectors.toList());
    }

    public List<Player> getAllKillAbleGameObject() {

        return gameObjects.values().stream()
                .filter(Player.class::isInstance )
                .filter( v -> v.getAttribute().isCanBeKilled() )
                .map( Player.class::cast )
                .collect(Collectors.toList());
    }
}
