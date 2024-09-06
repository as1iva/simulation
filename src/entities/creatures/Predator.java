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
        Coordinates nextPosition;
        int target = path.size() - 1;

        if (path.size() == speed) {
            nextPosition = initialPosition;

            if (map.getEntity(path.get(target)) instanceof Herbivore herbivore) {
                map.removeEntity(initialPosition, this);
                attackTarget(map, nextPosition, herbivore, path, target);
            }
        } else if (path.size() == 3) {
            nextPosition = path.get(1);

            if (map.getEntity(path.get(target)) instanceof Herbivore herbivore) {
                map.removeEntity(initialPosition, this);
                attackTarget(map, nextPosition, herbivore, path, target);
            }
        } else {
            nextPosition = path.get(speed);

            map.removeEntity(initialPosition, this);
            map.setEntity(nextPosition, this);
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
