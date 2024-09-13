package entities.creatures;

import entities.Entity;
import entities.environment.Grass;
import map.Coordinates;
import map.WorldMap;

import java.util.List;

public class Herbivore extends Creature {
    public Herbivore() {
        health = 100;
        speed = 1;
    }


    @Override
    public boolean canEat(Entity food) {
        return food instanceof Grass;
    }

    @Override
    public void makeMove(WorldMap worldMap, List<Coordinates> path, Coordinates initialPosition) {
        Coordinates nextPosition;

        if (path.size() <= speed) {
            nextPosition = path.get(path.size() - 1);
        } else {
            nextPosition = path.get(speed);
        }

        worldMap.removeEntity(initialPosition, this);

        if (worldMap.getEntity(nextPosition) instanceof Grass) {
            eatFood();
        }

        worldMap.setEntity(nextPosition, this);
    }

    public void eatFood() {
        if (this.health <= 80) {
            this.health += 20;
        } else {
            this.health = 100;
        }
    }
}
