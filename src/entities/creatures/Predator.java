package entities.creatures;

import logic.Coordinates;
import logic.Map;

import java.util.List;

public class Predator extends Creature {
    private static final int STRENGTH = 20;

    public Predator() {
        health = 100;
        speed = 2;
    }

    @Override
    public void makeMove(Map map, List<Coordinates> path, Coordinates initialPosition) {
        Coordinates nextPosition;

        if (path.size() <= speed) {
            nextPosition = path.get(path.size() - 1);
        } else {
            nextPosition = path.get(speed);
        }

        map.removeEntity(initialPosition, this);

        if (map.getEntity(nextPosition) instanceof Herbivore) {
            // attack herbivore
        }

        map.setEntity(nextPosition, this);
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
