package ch.hslu.ad.exercise.d3;

public class TombstoneableItem<T> {
    private boolean isDead;
    private T item;

    public boolean isDead() {
        return this.isDead;
    }

    public void kill() {
        this.isDead = true;
    }

    public void reincarnate(T item) {
        this.item = item;
        this.isDead = false;
    }

    public T getItem() {
        return item;
    }
}
