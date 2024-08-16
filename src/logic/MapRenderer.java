package logic;

import entities.Entity;
import entities.creatures.Herbivore;

public class MapRenderer {
    public static final String GROUND = "🟫 ";
    public static final String HERBIVORE = "🐄 ";
    public static final String PREDATOR = "🐺 ";
    public static final String GRASS = "🌱 ";
    public static final String ROCK = "🪨 ";
    public static final String TREE = "🌳 ";

    StringBuilder stringBuilder = new StringBuilder();
    public void render(Map map) {
        for (int y = 9; y > -1; y--) {
            stringBuilder.setLength(0);
            for (int x = 0; x < 10; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (map.isCellEmpty(coordinates)) {
                    stringBuilder.append(GROUND);
                } else {
                    stringBuilder.append(selectEmojiSpriteForEntity(map.getEntity(coordinates)));
                }
            }
            System.out.println(stringBuilder);
        }
    }

    private String selectEmojiSpriteForEntity(Entity entity) {
        switch (entity.getClass().getSimpleName()) {
            case "Herbivore":
                return HERBIVORE;
            case "Predator":
                return PREDATOR;
            case "Grass":
                return GRASS;
            case "Rock":
                return ROCK;
            case "Tree":
                return TREE;
        }
        return "";
    }
}
