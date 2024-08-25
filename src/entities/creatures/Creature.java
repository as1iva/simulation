package entities.creatures;

import entities.Entity;
import logic.Coordinates;
import logic.Map;

import java.util.List;

public abstract class Creature extends Entity {
    protected int health;
    protected int speed;

    public abstract void makeMove(Map map, List<Coordinates> path, Coordinates initialPosition);
}
