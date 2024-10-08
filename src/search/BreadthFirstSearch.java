package search;

import entities.creatures.Creature;
import map.Coordinates;
import map.WorldMap;

import java.util.*;

public class BreadthFirstSearch {
    public List<Coordinates> BFS(WorldMap worldMap, Coordinates coordinates, Creature creature) {

        Queue<Coordinates> queue = new LinkedList<>();
        List<Coordinates> checkedCells = new ArrayList<>();
        HashMap<Coordinates, Coordinates> path = new HashMap<>();
        List<Coordinates> newPath = new ArrayList<>();

        queue.offer(coordinates);

        while (!queue.isEmpty()) {
            coordinates = queue.poll();

            int x = coordinates.getX();
            int y = coordinates.getY();

            checkedCells.add(coordinates);

            if (creature.canEat(worldMap.getEntity(coordinates))) {
                return recreatePath(coordinates, checkedCells, path, newPath);
            }

            Coordinates[] directions = {
                    new Coordinates(x + 1, y),
                    new Coordinates(x - 1, y),
                    new Coordinates(x, y + 1),
                    new Coordinates(x, y - 1)
            };

            for (Coordinates nextCoordinates : directions) {
                int nextX = nextCoordinates.getX();
                int nextY = nextCoordinates.getY();

                boolean isValidMove = (
                        areCoordinatesInMapBounds(nextX, nextY) &&
                        isCellExplorable(checkedCells, queue, nextCoordinates) &&
                        canMove(worldMap, nextCoordinates, creature)
                );

                if (isValidMove) {
                    queue.offer(nextCoordinates);
                    path.put(nextCoordinates, coordinates);
                }
            }
        }
        return newPath;
    }

    private boolean areCoordinatesInMapBounds(int x, int y) {
        return x < WorldMap.MAP_WIDTH && x >= 0 && y < WorldMap.MAP_HEIGHT && y >= 0;
    }

    private boolean isCellExplorable(List<Coordinates> checkedCells, Queue<Coordinates> queue, Coordinates nextCoordinates) {
        return !checkedCells.contains(nextCoordinates) && !queue.contains(nextCoordinates);
    }

    private boolean canMove(WorldMap worldMap, Coordinates nextCoordinates, Creature creature) {
        return creature.canEat(worldMap.getEntity(nextCoordinates)) || worldMap.isCellEmpty(nextCoordinates);
    }

    private List<Coordinates> recreatePath(Coordinates coordinates, List<Coordinates> checkedCells, HashMap<Coordinates, Coordinates> path, List<Coordinates> newPath) {
        newPath.add(coordinates);

        while (!newPath.contains(checkedCells.get(0))) {
            for (Coordinates key : path.keySet()) {
                if (key.equals(coordinates)) {
                    newPath.add(path.get(coordinates));
                    coordinates = path.get(coordinates);
                }
            }
        }
        Collections.reverse(newPath);
        return newPath;
    }
}
