package map;

import entities.Entity;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.Grass;
import entities.environment.Rock;
import entities.environment.Tree;

import java.util.HashMap;
import java.util.Random;

public class Map {
    public static final int MAP_WIDTH = 20;
    public static final int MAP_HEIGHT = 20;
    private static final int HERBIVORE_COUNT = 14;
    private static final int PREDATOR_COUNT = 3;
    private static final int GRASS_COUNT = 80;
    private static final int ROCK_COUNT = 40;
    private static final int TREE_COUNT = 30;
    private final Random random = new Random();
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

    public void setUpRandomEntityPosition() {
        Class<?>[] arrayOfEntities = {
                Herbivore.class,
                Predator.class,
                Grass.class,
                Rock.class,
                Tree.class
        };

        int i = 0;

        while (true) {
            int xCoordinate = random.nextInt(MAP_WIDTH);
            int yCoordinate = random.nextInt(MAP_HEIGHT);

            if (entities.containsKey(new Coordinates(xCoordinate, yCoordinate))) {
                continue;
            }

            if (isEnoughObjectsPlaced(entities, arrayOfEntities, i)) {
                i++;
            }

            switch (i) {
                case 0 -> setEntity(new Coordinates(xCoordinate, yCoordinate), new Herbivore());
                case 1 -> setEntity(new Coordinates(xCoordinate, yCoordinate), new Predator());
                case 2 -> setEntity(new Coordinates(xCoordinate, yCoordinate), new Grass());
                case 3 -> setEntity(new Coordinates(xCoordinate, yCoordinate), new Rock());
                case 4 -> setEntity(new Coordinates(xCoordinate, yCoordinate), new Tree());
            }

            if (entities.size() == HERBIVORE_COUNT + PREDATOR_COUNT + GRASS_COUNT + ROCK_COUNT + TREE_COUNT) {
                break;
            }
        }
    }

    private boolean isEnoughObjectsPlaced(HashMap<Coordinates, Entity> entities, Class<?>[] arrayOfEntities, int i) {
        int[] countOfEntities = {HERBIVORE_COUNT, PREDATOR_COUNT, GRASS_COUNT, ROCK_COUNT, TREE_COUNT};
        int count = 0;

        for (Entity entity : entities.values()) {
            if (arrayOfEntities[i].isInstance(entity)) {
                count++;
            }
        }

        return count == countOfEntities[i];
    }
}