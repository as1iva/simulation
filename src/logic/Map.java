package logic;

import entities.Entity;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.objects.Grass;

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
}
