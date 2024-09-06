package search;

import entities.creatures.Creature;
import map.Coordinates;
import map.Map;

import java.util.*;

public class BreadthFirstSearch {
    public List<Coordinates> BFS(Map map, Coordinates coordinates, Creature entity) {

        Queue<Coordinates> queue = new LinkedList<>();
        List<Coordinates> checkedEntities = new ArrayList<>();
        HashMap<Coordinates, Coordinates> path = new HashMap<>();
        List<Coordinates> newPath = new ArrayList<>();

        queue.offer(coordinates);

        while (!queue.isEmpty()) {
            coordinates = queue.poll();

            int x = coordinates.getX();
            int y = coordinates.getY();

            checkedEntities.add(coordinates);

            if (entity.canEat(map.getEntity(coordinates))) {
                return recreatePath(coordinates, checkedEntities, path, newPath);
            }

            Coordinates[] directions = {
                    new Coordinates(x + 1, y),
                    new Coordinates(x - 1, y),
                    new Coordinates(x, y + 1),
                    new Coordinates(x, y - 1)
            };

            for (Coordinates newCoordinates : directions) {
                int newX = newCoordinates.getX();
                int newY = newCoordinates.getY();

                boolean isValidMove = (areCoordinatesInMapBounds(newX, newY) &&
                        !checkedEntities.contains(newCoordinates) &&
                        !queue.contains(newCoordinates) &&
                        !(map.getEntity(newCoordinates) instanceof Rock) &&
                        !(map.getEntity(newCoordinates) instanceof Tree));

                if (entity instanceof Herbivore) {
                    isValidMove = isValidMove &&
                            !(map.getEntity(newCoordinates) instanceof Predator) &&
                            !(map.getEntity(newCoordinates) instanceof Herbivore);
                }

                if (entity instanceof Predator) {
                    isValidMove = isValidMove &&
                            !(map.getEntity(newCoordinates) instanceof Predator) &&
                            !(map.getEntity(newCoordinates) instanceof Grass);
                }

                if (isValidMove) {
                    queue.offer(newCoordinates);
                    path.put(newCoordinates, coordinates);
                }
            }
        }
        return newPath;
    }

    private boolean areCoordinatesInMapBounds(int x, int y) {
        return x < Map.MAP_WIDTH && x >= 0 && y < Map.MAP_HEIGHT && y >= 0;
    }

    private List<Coordinates> recreatePath(Coordinates coordinates, List<Coordinates> checkedEntities, HashMap<Coordinates, Coordinates> path, List<Coordinates> newPath) {
        newPath.add(coordinates);

        while (!newPath.contains(checkedEntities.get(0))) {
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
