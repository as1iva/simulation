package map;

import entities.Entity;

import java.util.HashMap;

public class Map {
    public static final int MAP_WIDTH = 20;
    public static final int MAP_HEIGHT = 20;

    public HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntity(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates, Entity entity) {
        entities.remove(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }
}
