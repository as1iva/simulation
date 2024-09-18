package actions.initActions;

import actions.Action;
import entities.environment.Rock;
import map.Coordinates;
import map.WorldMap;

public class RockSpawnAction extends Action {
    private static final int ROCK_COUNT = 40;

    protected void perform(WorldMap worldMap) {
        for (int i = 0; i < ROCK_COUNT; i++) {
            if (canGetEmptyCoordinates(worldMap)) {
                Coordinates coordinates = getEmptyRandomCoordinates(worldMap);
                worldMap.setEntity(coordinates, new Rock());
            }
        }
    }
}
