package actions.initActions;

import actions.Action;
import entities.creatures.Predator;
import map.Coordinates;
import map.Map;

public class PredatorSpawnAction extends Action {
    private static final int PREDATOR_COUNT = 3;

    protected void perform(Map map) {
        for (int i = 0; i < PREDATOR_COUNT; i++) {
            Coordinates coordinates = getEmptyRandomCoordinates(map);
            map.setEntity(coordinates, new Predator());
        }
    }
}
