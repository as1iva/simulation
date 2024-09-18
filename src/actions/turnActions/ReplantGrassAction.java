package actions.turnActions;

import actions.Action;
import entities.environment.Grass;
import map.Coordinates;
import map.WorldMap;

public class ReplantGrassAction extends Action {
    public void perform(WorldMap worldMap) {
        final int GRASS_COUNT = 10;

        for (int i = 0; i < GRASS_COUNT; i++) {
            if (canGetEmptyCoordinates(worldMap)) {
                Coordinates coordinates = getEmptyRandomCoordinates(worldMap);
                replantGrass(worldMap, coordinates);
            }
        }
    }

    private void replantGrass(WorldMap worldMap, Coordinates coordinates) {
        worldMap.setEntity(coordinates, new Grass());
    }
}
