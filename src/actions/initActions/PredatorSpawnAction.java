package actions.initActions;

import actions.Action;
import entities.creatures.Predator;
import map.Coordinates;
import map.WorldMap;

public class PredatorSpawnAction extends Action {
    private static final int PREDATOR_COUNT = 3;

    protected void perform(WorldMap worldMap) {
        for (int i = 0; i < PREDATOR_COUNT; i++) {
            Coordinates coordinates = getEmptyRandomCoordinates(worldMap);
            worldMap.setEntity(coordinates, new Predator());
        }
    }
}
