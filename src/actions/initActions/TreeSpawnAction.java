package actions.initActions;

import actions.Action;
import entities.environment.Tree;
import map.Coordinates;
import map.WorldMap;

public class TreeSpawnAction extends Action {
    private static final int TREE_COUNT = 30;

    protected void perform(WorldMap worldMap) {
        for (int i = 0; i < TREE_COUNT; i++) {
            Coordinates coordinates = getEmptyRandomCoordinates(worldMap);
            worldMap.setEntity(coordinates, new Tree());
        }
    }
}
