package entities.creatures;

import entities.objects.Grass;
import logic.Coordinates;
import logic.Map;

import java.util.List;

public class Herbivore extends Creature {
    public Herbivore() {
        health = 100;
        speed = 1;
    }

    public void eatFood() {
        // eat grass
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
        map.setEntity(nextPosition, this);

        if (map.getEntity(nextPosition) instanceof Grass) {
            eatFood();
        }
    }
}
