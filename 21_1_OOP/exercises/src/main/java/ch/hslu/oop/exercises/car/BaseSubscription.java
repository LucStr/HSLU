package ch.hslu.oop.exercises.car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class BaseSubscription implements Subscribable{
    private List<PropertyChangeListener> listenerList;

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        listenerList.remove(listener);
    }


    protected void firePropertyChangeEvent(PropertyChangeEvent eventObject){
        for (PropertyChangeListener listener : listenerList) {
            listener.propertyChange(eventObject);
        }
    }
}

