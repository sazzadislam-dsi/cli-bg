package org.ni.rpg.factory;

import org.ni.rpg.entity.*;
import org.ni.rpg.singleton.GameController;
import org.ni.rpg.strategy.DrawStrategy;
import org.ni.rpg.strategy.impl.GameObjectDrawStrategy;
import org.ni.rpg.utils.Commons;
import org.ni.rpg.utils.Config;
import org.ni.rpg.utils.Constants;

import java.util.Random;

public class GameObjectFactory implements GameObjectAbstractFactory {
    @Override
    public Player createPlayer(int positionX, int positionY, Character[][] content, String color, double attack, int range, int protection, String name, String description, double health, char direction) {
        Attribute attribute = new Attribute(true, false, true, true, false, true);
        Dimension dimension = Commons.calculateDimension(content);
        Appearance appearance = new Appearance(positionX, positionY, dimension, content, color, true);
        DrawStrategy drawStrategy = new GameObjectDrawStrategy();
        Weapon weapon = new Weapon(appearance, attribute, attack, range, drawStrategy);
        Shield shield = new Shield(appearance, attribute, protection, drawStrategy);
        return new Player(appearance, attribute, name, description, health, direction, weapon, shield, drawStrategy);
    }



    @Override
    public GameState createGameMap(String name) {
        Attribute attribute = new Attribute(false, true, false, false, false, false);
        Dimension dimension = new Dimension(Config.MAX_HEIGHT,Config.MAX_WIDTH);
        Character[][] content = Commons.generateGameStateContent(Config.MAX_HEIGHT,Config.MAX_WIDTH);
        Appearance appearance = new Appearance(0, 0, dimension, content, "", true);
        GameState gameState = new GameState(appearance, attribute);

        Random rand = new Random();
        int positionX = rand.nextInt((Config.MAX_WIDTH - 1) + 1) + 1;
        int positionY = rand.nextInt((Config.MAX_HEIGHT - 1) + 1) + 1;
        Character[][] playerContent = Constants.PLAYER_CHAR;
        String color = "";
        double attack = Config.AI_PLAYER_ATTACK;
        int range = Config.AI_PLAYER_RANGE;
        int protection = 0;
        String description = "";
        double health = Config.PLAYER_HEALTH;
        char direction = 'u';
        Player player = createPlayer(positionX,positionY,playerContent,color,attack,range,protection,name,description,health,direction);
        gameState.addGameObject(player);
        gameState.setPlayerId(player.getId());
        for(int i=0; i < Config.AI_PLAYER; i++){
            positionX = rand.nextInt((Config.MAX_WIDTH - 1) + 1) + 1;
            positionY = rand.nextInt((Config.MAX_HEIGHT - 1) + 1) + 1;
            playerContent = Constants.ENEMY_CHAR;
            attack = Config.AI_PLAYER_ATTACK;
            range = Config.AI_PLAYER_RANGE;
            String aiPlayerName = "Enemy-"+1;
            health = Config.AI_PLAYER_HEALTH;
            Player aiPlayer = createPlayer(positionX,positionY,playerContent,color,attack,range,protection,aiPlayerName,description,health,direction);
            gameState.addGameObject(aiPlayer);
        }
        return gameState;
    }
}
