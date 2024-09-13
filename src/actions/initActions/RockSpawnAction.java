package actions.initActions;

import actions.Action;
import entities.environment.Rock;
import map.Coordinates;
import map.Map;

public class RockSpawnAction extends Action {
    private static final int ROCK_COUNT = 40;

    protected void perform(Map map) {
        for (int i = 0; i < ROCK_COUNT; i++) {
            Coordinates coordinates = getEmptyRandomCoordinates(map);
            map.setEntity(coordinates, new Rock());
        }
    }
}
