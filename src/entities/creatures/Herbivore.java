package entities.creatures;

public class Herbivore extends Creature {
    public Herbivore() {
        health = 100;
        speed = 1;
    }

    public void eatFood() {
        // eat grass
    }

    @Override
    public void makeMove() {
        // find grass
    }
}
