package org.ni.rpg.factory;

import org.ni.rpg.entity.*;
import org.ni.rpg.singleton.GameController;
import org.ni.rpg.strategy.DrawStrategy;
import org.ni.rpg.strategy.impl.GameObjectDrawStrategy;
import org.ni.rpg.strategy.impl.PlayerDrawStrategy;
import org.ni.rpg.utils.Commons;
import org.ni.rpg.utils.Config;
import org.ni.rpg.utils.Constants;

import java.util.Random;

public class GameObjectFactory implements GameObjectAbstractFactory {
    @Override
    public Player createPlayer(int positionX, int positionY, Character[][] content, String color, double attack, int range, int protection, String name, String description, double health, String direction,int speed) {
        Attribute attribute = new Attribute(true, false, true, true, false, true);
        Dimension dimension = Commons.calculateDimension(content);
        Appearance appearance = new Appearance(positionX, positionY, dimension, content, color, true, direction);
        DrawStrategy drawStrategy = new PlayerDrawStrategy();
        Weapon weapon = new Weapon(appearance, attribute, attack, range, drawStrategy);
        Shield shield = new Shield(appearance, attribute, protection, drawStrategy);
        return new Player(appearance, attribute, name, description, health, weapon, shield, drawStrategy,speed);
    }



    @Override
    public GameState createGameMap(String name) {
        Attribute attribute = new Attribute(false, true, false, false, false, false);
        Dimension dimension = new Dimension(Config.MAX_HEIGHT-2,Config.MAX_WIDTH-2);
        Character[][] content = Commons.generateGameStateContent(Config.MAX_HEIGHT-2,Config.MAX_WIDTH-2);
        Appearance appearance = new Appearance(0, 0, dimension, content, "", true, "");
        GameState gameState = new GameState(appearance, attribute);
        Random rand = new Random();
        int positionX = Commons.randInt(1,Config.MAX_WIDTH-5);
        int positionY = Commons.randInt(1,Config.MAX_HEIGHT-5);
        Character[][] playerContent = Constants.PLAYER_CHAR;
        String color = "";
        double attack = Config.PLAYER_ATTACK;
        int range = Config.PLAYER_RANGE;
        int speed = Config.PLAYER_SPEED;
        int protection = 0;
        String description = "";
        double health = Config.PLAYER_HEALTH;
        String direction = Commons.getDirection();
        Player player = createPlayer(positionX,positionY,playerContent,color,attack,range,protection,name,description,health,direction,speed);
        gameState.addGameObject(player);
        gameState.setPlayerId(player.getId());
        for(int i=0; i < Config.AI_PLAYER; i++){
            positionX = Commons.randInt(1,Config.MAX_WIDTH-5);
            positionY = Commons.randInt(1,Config.MAX_HEIGHT-5);
            playerContent = Constants.ENEMY_CHAR;
            attack = Config.AI_PLAYER_ATTACK;
            range = Config.AI_PLAYER_RANGE;
            speed = Config.AI_PLAYER_SPEED;
            String aiPlayerName = "Enemy-"+i;
            health = Config.AI_PLAYER_HEALTH;
            direction = Commons.getDirection();
            Player aiPlayer = createPlayer(positionX,positionY,playerContent,color,attack,range,protection,aiPlayerName,description,health,direction,speed);
            gameState.addGameObject(aiPlayer);
        }
        return gameState;
    }
}
