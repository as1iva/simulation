package actions;

import map.Coordinates;
import map.WorldMap;

import java.util.Random;

public class Action {
    protected Coordinates getEmptyRandomCoordinates(WorldMap worldMap) {
        final Random random = new Random();

        while (true) {
            int x = random.nextInt(WorldMap.MAP_WIDTH);
            int y = random.nextInt(WorldMap.MAP_HEIGHT);

            if (!worldMap.entities.containsKey(new Coordinates(x, y))) {
                return new Coordinates(x, y);
            }
        }
    }
}
