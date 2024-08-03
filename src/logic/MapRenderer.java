package logic;

import entities.Entity;

public class MapRenderer {
    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_LIGHT_GREEN = "\033[48;5;28m";
    public static final String ANSI_DARK_GREEN = "\033[48;5;70m";

    StringBuilder stringBuilder = new StringBuilder();
    public void render(Map map) {
        for (int y = 10; y > 0; y--) {
            stringBuilder.setLength(0);
            for (int x = 0; x < 10; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (map.isCellEmpty(coordinates)) {
                    stringBuilder.append(getSpriteForEmptyCell(coordinates));
                }
            }
            stringBuilder.append(ANSI_RESET);
            System.out.println(stringBuilder);
        }
    }

    private String colorizeSprite(String sprite, boolean isCellDark) {
        String result = sprite;

        if (isCellDark) {
            result = ANSI_DARK_GREEN + result;
        } else {
            result = ANSI_LIGHT_GREEN + result;
        }

        return result;
    }

    private String getSpriteForEmptyCell(Coordinates coordinates) {
        return colorizeSprite("   ", Map.isCellDark(coordinates));
    }
}
