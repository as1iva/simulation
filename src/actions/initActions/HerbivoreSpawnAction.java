package actions.initActions;

import actions.Action;
import entities.creatures.Herbivore;
import map.Coordinates;
import map.WorldMap;

public class HerbivoreSpawnAction extends Action {
    private static final int HERBIVORE_COUNT = 14;

    protected void perform(WorldMap worldMap) {
        for (int i = 0; i < HERBIVORE_COUNT; i++) {
            Coordinates coordinates = getEmptyRandomCoordinates(worldMap);
            worldMap.setEntity(coordinates, new Herbivore());
        }
    }
}
