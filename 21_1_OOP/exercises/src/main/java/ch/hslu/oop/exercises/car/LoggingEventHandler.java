package ch.hslu.oop.exercises.car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggingEventHandler implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        System.out.println(propertyChangeEvent);
    }
}
