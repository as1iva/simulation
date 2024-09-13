package actions.initActions;

import actions.Action;
import entities.environment.Grass;
import map.Coordinates;
import map.Map;

public class GrassSpawnAction extends Action {
    private static final int GRASS_COUNT = 80;

    protected void perform(Map map) {
        for (int i = 0; i < GRASS_COUNT; i++) {
            Coordinates coordinates = getEmptyRandomCoordinates(map);
            map.setEntity(coordinates, new Grass());
        }
    }
}
