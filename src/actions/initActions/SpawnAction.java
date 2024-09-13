package actions.initActions;

import actions.Action;
import map.WorldMap;

public class SpawnAction extends Action {
    private final WorldMap worldMap;
    private final GrassSpawnAction spawnGrassAction = new GrassSpawnAction();
    private final HerbivoreSpawnAction spawnHerbivoreAction = new HerbivoreSpawnAction();
    private final PredatorSpawnAction spawnPredatorAction = new PredatorSpawnAction();
    private final RockSpawnAction spawnRockAction = new RockSpawnAction();
    private final TreeSpawnAction spawnTreeAction = new TreeSpawnAction();

    public SpawnAction(WorldMap worldMap) {
       this.worldMap = worldMap;
    }

    public void perform() {
        spawnGrassAction.perform(worldMap);
        spawnHerbivoreAction.perform(worldMap);
        spawnPredatorAction.perform(worldMap);
        spawnRockAction.perform(worldMap);
        spawnTreeAction.perform(worldMap);
    }
}
