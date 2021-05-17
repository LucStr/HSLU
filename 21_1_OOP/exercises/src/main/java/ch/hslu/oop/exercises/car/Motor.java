package ch.hslu.oop.exercises.car;

import java.beans.PropertyChangeEvent;

public class Motor extends BaseSubscription implements Switchable {
    private int rpm;
    private MotorState motorState;
    public static int RPM_WHEN_ON = 100;

    public Motor(){
        motorState = MotorState.OFF;
    }

    private void setRpm(int rpm){
        if(this.rpm == rpm){
            return;
        }

        var eventObject = new PropertyChangeEvent(this, "rpm", this.rpm, rpm);
        this.rpm = rpm;
        firePropertyChangeEvent(eventObject);
    }

    private void setMotorState(MotorState motorState){
        if(this.motorState == motorState){
            return;
        }

        var eventObject = new PropertyChangeEvent(this, "motorState", this.motorState, motorState);
        this.motorState = motorState;
        firePropertyChangeEvent(eventObject);
    }

    public int getRPM(){
        return this.rpm;
    }

    @Override
    public void switchOn() {
        setRpm(RPM_WHEN_ON);
        setMotorState(MotorState.ON);
    }

    @Override
    public void switchOff() {
        setRpm(0);
        setMotorState(MotorState.OFF);
    }

    @Override
    public boolean isSwitchedOn() {
        return this.rpm > 0 && this.motorState == MotorState.ON;
    }

    @Override
    public boolean isSwitchedOff() {

        return rpm == 0 && this.motorState == MotorState.OFF;
    }
}
