package ch.hslu.oop.exercises.temperature;

public class Mercury extends ChemicalElement {
    public Mercury() {
        super("Hg", "Quecksilber", -38.83f, 356.73f);
    }

    @Override
    public String toString() {
        return super.toString() + " GIFTIG!";
    }
}
