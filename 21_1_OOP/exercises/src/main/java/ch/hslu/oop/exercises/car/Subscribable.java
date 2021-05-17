package ch.hslu.oop.exercises.car;

import java.beans.PropertyChangeListener;

public interface Subscribable {
    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}
