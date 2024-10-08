package actions.initActions;

import actions.Action;
import entities.environment.Grass;
import map.Coordinates;
import map.WorldMap;

public class GrassSpawnAction extends Action {
    private static final int GRASS_COUNT = 80;

    protected void perform(WorldMap worldMap) {
        for (int i = 0; i < GRASS_COUNT; i++) {
            if (canGetEmptyCoordinates(worldMap)) {
                Coordinates coordinates = getEmptyRandomCoordinates(worldMap);
                worldMap.setEntity(coordinates, new Grass());
            }
        }
    }
}
