package logic;

import entities.Entity;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntity(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public void setUpRandomEntityPositions() {
        // make randomizer of positions
    }

    public static boolean isCellDark(Coordinates coordinates) {
        return ((coordinates.X + coordinates.Y) % 2) == 0;
    }
}
