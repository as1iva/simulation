package entities.creatures;

import entities.Entity;

public abstract class Creature extends Entity {
    protected static int health;
    protected static int speed;

    public abstract void makeMove();
}
