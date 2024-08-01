public class Herbivore extends Creature {
    public Herbivore() {
        entityView = "🐄";
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
