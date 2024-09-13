package entities.creatures;

import entities.Entity;
import map.Coordinates;
import map.WorldMap;

import java.util.List;

public abstract class Creature extends Entity {
    protected int health;
    protected int speed;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract boolean canEat(Entity food);

    public abstract void makeMove(WorldMap worldMap, List<Coordinates> path, Coordinates initialPosition);
}
