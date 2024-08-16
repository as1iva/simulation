package logic;

import entities.Entity;

public class MapRenderer {
    public static final String GROUND = "🟫 ";

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
                return "🐄 ";
            case "Predator":
                return "🐺 ";
            case "Grass":
                return "🌱 ";
            case "Rock":
                return "🪨 ";
            case "Tree":
                return "🌳 ";
        }
        return "";
    }
}
