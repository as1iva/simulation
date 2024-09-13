package actions.turnActions;

import actions.Action;
import entities.Entity;
import entities.creatures.Creature;
import search.BreadthFirstSearch;
import map.Coordinates;
import map.WorldMap;

import java.util.*;

public class MoveEntitiesAction extends Action {
    private final WorldMap worldMap;
    private final BreadthFirstSearch breadthFirstSearch;

    public MoveEntitiesAction(WorldMap worldMap, BreadthFirstSearch breadthFirstSearch) {
        this.worldMap = worldMap;
        this.breadthFirstSearch = breadthFirstSearch;
    }

    public void perform() {
        List<Entity> entities = new ArrayList<>();
        Queue<Coordinates> movableEntities = chooseMovableEntities();

        while (!movableEntities.isEmpty()) {
            moveEntity(movableEntities, entities);
        }
    }

    public void moveEntity(Queue<Coordinates> movableEntities, List<Entity> entities) {
        Coordinates coordinates = movableEntities.poll();
        Entity entity = worldMap.getEntity(coordinates);

        if (!entities.contains(entity)) {
            if (entity instanceof Creature creature) {
                List<Coordinates> path = breadthFirstSearch.BFS(worldMap, coordinates, creature);
                if (!path.isEmpty()) {
                    creature.makeMove(worldMap, path, coordinates);
                    entities.add(creature);
                }
            }
        }
    }

    private Queue<Coordinates> chooseMovableEntities() {
        Queue<Coordinates> movableEntities = new LinkedList<>();

        for (Coordinates coordinates : worldMap.entities.keySet()) {
            Entity entity = worldMap.getEntity(coordinates);
            if (entity instanceof Creature) {
                movableEntities.offer(coordinates);
            }
        }
        return movableEntities;
    }

    public boolean hasPath(WorldMap worldMap) {
        for (Coordinates coordinates : worldMap.entities.keySet()) {
            Entity entity = worldMap.getEntity(coordinates);
            if (entity instanceof Creature creature) {
                List<Coordinates> path = breadthFirstSearch.BFS(worldMap, coordinates, creature);
                if (!path.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
}
