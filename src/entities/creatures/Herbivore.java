package entities.creatures;

import entities.environment.Grass;
import map.Coordinates;
import map.Map;

import java.util.List;
import java.util.Random;

public class Herbivore extends Creature {
    public Herbivore() {
        health = 100;
        speed = 1;
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

        if (map.getEntity(nextPosition) instanceof Grass) {
            eatFood();
            replantGrass(map);
        }

        map.setEntity(nextPosition, this);
    }

    public void eatFood() {
        if (this.health <= 80) {
            this.health += 20;
        } else {
            this.health = 100;
        }
    }

    private void replantGrass(Map map) {
        final Random random = new Random();

        int x = random.nextInt(Map.MAP_WIDTH);
        int y = random.nextInt(Map.MAP_HEIGHT);

        boolean choice = random.nextBoolean();

        if (choice && !map.entities.containsKey(new Coordinates(x, y))) {
            map.setEntity(new Coordinates(x, y), new Grass());
        }
    }
}
