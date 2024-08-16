package logic;

import entities.Entity;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.objects.Grass;
import entities.objects.Rock;
import entities.objects.Tree;

import java.util.HashMap;
import java.util.Random;

public class Map {
    Random random = new Random();
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

    public void setUpRandomEntityPosition() {
        Entity[] arrayOfEntities = {new Herbivore(), new Predator(), new Grass(), new Rock(), new Tree()};
        int i = 0;

        while (true) {
            int xCoordinate = random.nextInt(10);
            int yCoordinate = random.nextInt(10);

            if (entities.containsKey(new Coordinates(xCoordinate, yCoordinate))) {
                continue;
            }

            if (isEnoughObjectsPlaced(entities, arrayOfEntities, i)) {
                i++;
            }

            setEntity(new Coordinates(xCoordinate, yCoordinate), arrayOfEntities[i]);

            if (entities.size() == 16) {
                break;
            }
        }
    }

    private boolean isEnoughObjectsPlaced(HashMap<Coordinates, Entity> entities, Entity[] arrayOfEntities, int i) {
        int[] countOfEntities = {4, 2, 5, 2, 3};
        int count = 0;

        for (Entity entity : entities.values()) {
            if (entity.equals(arrayOfEntities[i])) {
                count++;
            }
        }

        return count == countOfEntities[i];
    }
}
