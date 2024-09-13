package entities.creatures;

import entities.Entity;
import map.Coordinates;
import map.Map;

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
    public void makeMove(Map map, List<Coordinates> path, Coordinates initialPosition) {
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

            map.removeEntity(initialPosition, this);
            map.setEntity(nextPosition, this);

            return;
        }

        if (map.getEntity(path.get(target)) instanceof Herbivore herbivore) {
            map.removeEntity(initialPosition, this);
            attackTarget(map, nextPosition, herbivore, path, target);
        }
    }


    public void attackTarget(Map map, Coordinates nextPosition, Herbivore herbivore, List<Coordinates> path, int target) {
        if (herbivore.getHealth() > STRENGTH) {
            map.setEntity(nextPosition, this);
            herbivore.setHealth(herbivore.getHealth() - STRENGTH);
        } else {
            herbivore.setHealth(herbivore.getHealth() - STRENGTH);
            map.setEntity(path.get(target), this);
        }
    }
}
