package ch.hslu.oop.exercises.car;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car implements Switchable{
    private boolean state;
    private Motor motor;
    private Light leftLight;
    private Light rightLight;

    public Car(){
        motor = new Motor();
        leftLight = new Light();
        rightLight = new Light();
    }

    @Override
    public void switchOn() {
        state = true;
        motor.switchOn();
    }

    @Override
    public void switchOff() {
        state = false;
        motor.switchOff();
    }

    @Override
    public boolean isSwitchedOn() {
        return state;
    }

    @Override
    public boolean isSwitchedOff() {
        return !state;
    }

    private class MotorEventListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

        }
    }
}
