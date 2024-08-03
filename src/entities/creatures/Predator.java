package entities.creatures;

public class Predator extends Creature {
    private static final int STRENGTH = 20;

    public Predator() {
        entityView = "🐺";
        health = 100;
        speed = 3;
    }

    @Override
    public void makeMove() {
        // find herbivore
    }
}
