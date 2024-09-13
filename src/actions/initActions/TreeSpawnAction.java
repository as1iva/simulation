package actions.initActions;

import actions.Action;
import entities.environment.Tree;
import map.Coordinates;
import map.Map;

public class TreeSpawnAction extends Action {
    private static final int TREE_COUNT = 30;

    protected void perform(Map map) {
        for (int i = 0; i < TREE_COUNT; i++) {
            Coordinates coordinates = getEmptyRandomCoordinates(map);
            map.setEntity(coordinates, new Tree());
        }
    }
}
