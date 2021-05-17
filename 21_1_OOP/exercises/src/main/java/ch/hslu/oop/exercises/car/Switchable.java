package ch.hslu.oop.exercises.car;

/**
 * This interface is used to represent Objects, which can be turned on and off
 */
public interface Switchable {
    /**
     * Will switch the object on.
     */
    void switchOn();

    /**
     * Will switch the object off.
     */
    void switchOff();

    /**
     * Will tell you if the object is turned on
     * @return true when switched on
     */
    boolean isSwitchedOn();

    /**
     * Will tell you if the object is turned off
     * @return true when switched off
     */
    boolean isSwitchedOff();
}