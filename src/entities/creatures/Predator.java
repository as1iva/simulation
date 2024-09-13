package entities.creatures;

import entities.Entity;
import map.Coordinates;
import map.WorldMap;

import java.util.List;

public class Predator extends Creature {
    private static final int STRENGTH = 20;

    public Predator() {
        health = 100;
        speed = 2;
    }

    @Override
    public boolean canEat(Entity food) {
        return food instanceof Herbivore;
    }

    @Override
    public void makeMove(WorldMap worldMap, List<Coordinates> path, Coordinates initialPosition) {
        final int LAST_STEP_BEFORE_TARGET = speed - 1;
        final int WITHIN_REACH_OF_TARGET = speed + 1;
        final int NEXT_TO_TARGET = 2;

        Coordinates nextPosition;
        int target = path.size() - 1;

        if (path.size() == NEXT_TO_TARGET) {
            nextPosition = initialPosition;
        } else if (path.size() == WITHIN_REACH_OF_TARGET) {
            nextPosition = path.get(LAST_STEP_BEFORE_TARGET);
        } else {
            nextPosition = path.get(speed);

            worldMap.removeEntity(initialPosition, this);
            worldMap.setEntity(nextPosition, this);

            return;
        }

        if (worldMap.getEntity(path.get(target)) instanceof Herbivore herbivore) {
            worldMap.removeEntity(initialPosition, this);
            attackTarget(worldMap, nextPosition, herbivore, path, target);
        }
    }


    public void attackTarget(WorldMap worldMap, Coordinates nextPosition, Herbivore herbivore, List<Coordinates> path, int target) {
        if (herbivore.getHealth() > STRENGTH) {
            worldMap.setEntity(nextPosition, this);
            herbivore.setHealth(herbivore.getHealth() - STRENGTH);
        } else {
            herbivore.setHealth(herbivore.getHealth() - STRENGTH);
            worldMap.setEntity(path.get(target), this);
        }
    }
}
