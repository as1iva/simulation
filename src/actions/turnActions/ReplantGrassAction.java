package actions.turnActions;

import actions.Action;
import entities.environment.Grass;
import map.Coordinates;
import map.Map;

public class ReplantGrassAction extends Action {
    public void perform(Map map) {
        final int GRASS_COUNT = 10;

        for (int i = 0; i < GRASS_COUNT; i++) {
            Coordinates coordinates = getEmptyRandomCoordinates(map);
            replantGrass(map, coordinates);
        }
    }

    private void replantGrass(Map map, Coordinates coordinates) {
        map.setEntity(coordinates, new Grass());
    }
}
