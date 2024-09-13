package actions;

import map.Coordinates;
import map.Map;

import java.util.Random;

public class Action {
    protected Coordinates getEmptyRandomCoordinates(Map map) {
        final Random random = new Random();

        while (true) {
            int x = random.nextInt(Map.MAP_WIDTH);
            int y = random.nextInt(Map.MAP_HEIGHT);

            if (!map.entities.containsKey(new Coordinates(x, y))) {
                return new Coordinates(x, y);
            }
        }
    }
}
