package map;

import entities.Entity;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.Grass;
import entities.environment.Rock;
import entities.environment.Tree;

public class MapRenderer {
    public static final String GROUND = "🟫 ";
    public static final String HERBIVORE = "🐮 ";
    public static final String PREDATOR = "🐯 ";
    public static final String GRASS = "🌱 ";
    public static final String ROCK = "🪨 ";
    public static final String TREE = "🌲 ";
    private static final String EMPTY = "";

    StringBuilder stringBuilder = new StringBuilder();
    public void render(WorldMap worldMap) {
        for (int y = WorldMap.MAP_HEIGHT - 1; y > -1; y--) {
            stringBuilder.setLength(0);
            for (int x = 0; x < WorldMap.MAP_WIDTH; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (worldMap.isCellEmpty(coordinates)) {
                    stringBuilder.append(GROUND);
                } else {
                    stringBuilder.append(selectEmojiSpriteForEntity(worldMap.getEntity(coordinates)));
                }
            }
            System.out.println(stringBuilder);
        }
    }

    private String selectEmojiSpriteForEntity(Entity entity) {
        if (entity instanceof Herbivore) {
            return HERBIVORE;
        } else if (entity instanceof Predator) {
            return PREDATOR;
        } else if (entity instanceof Grass) {
            return GRASS;
        } else if (entity instanceof Rock) {
            return ROCK;
        } else if (entity instanceof Tree) {
            return TREE;
        }
        return EMPTY;
    }
}
