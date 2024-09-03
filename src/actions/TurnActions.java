package actions;

import entities.Entity;
import entities.creatures.Creature;
import logic.BreadthFirstSearch;
import map.Coordinates;
import map.Map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TurnActions {
    private final Map map;
    private final BreadthFirstSearch breadthFirstSearch;

    public TurnActions(Map map, BreadthFirstSearch breadthFirstSearch) {
        this.map = map;
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
        Entity entity = map.getEntity(coordinates);

        if (!entities.contains(entity)) {
            if (entity instanceof Creature creature) {
                List<Coordinates> path = breadthFirstSearch.BFS(map, coordinates, entity);
                if (!path.isEmpty()) {
                    creature.makeMove(map, path, coordinates);
                    entities.add(creature);
                }
            }
        }
    }

    private Queue<Coordinates> chooseMovableEntities() {
        Queue<Coordinates> movableEntities = new LinkedList<>();

        for (Coordinates coordinates : map.entities.keySet()) {
            Entity entity = map.getEntity(coordinates);
            if (entity instanceof Creature) {
                movableEntities.offer(coordinates);
            }
        }
        return movableEntities;
    }

    public boolean hasPath(Map map) {
        for (Coordinates coordinates : map.entities.keySet()) {
            Entity entity = map.getEntity(coordinates);
            if (entity instanceof Creature) {
                List<Coordinates> path = breadthFirstSearch.BFS(map, coordinates, entity);
                if (!path.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
}
