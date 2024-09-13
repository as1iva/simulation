package actions.initActions;

import actions.Action;
import map.Map;

public class SpawnAction extends Action {
    private final Map map;
    private final GrassSpawnAction spawnGrassAction = new GrassSpawnAction();
    private final HerbivoreSpawnAction spawnHerbivoreAction = new HerbivoreSpawnAction();
    private final PredatorSpawnAction spawnPredatorAction = new PredatorSpawnAction();
    private final RockSpawnAction spawnRockAction = new RockSpawnAction();
    private final TreeSpawnAction spawnTreeAction = new TreeSpawnAction();

    public SpawnAction(Map map) {
       this.map = map;
    }

    public void perform() {
        spawnGrassAction.perform(map);
        spawnHerbivoreAction.perform(map);
        spawnPredatorAction.perform(map);
        spawnRockAction.perform(map);
        spawnTreeAction.perform(map);
    }
}
