package entities;

public abstract class Entity {
    protected static String entityView;

    @Override
    public String toString() {
        return entityView;
    }
}
