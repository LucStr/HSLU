package ch.hslu.oop.exercises.car;

import java.beans.PropertyChangeEvent;

public class Light extends BaseSubscription implements Switchable {
    private int lumen;

    public Light(){

    }

    private void setLumen(int lumen){
        if(this.lumen == lumen){
            return;
        }

        var event = new PropertyChangeEvent(this, "lumen", this.lumen, lumen);
        this.lumen = lumen;
        firePropertyChangeEvent(event);
    }

    @Override
    public void switchOn() {
        setLumen(10);
    }

    @Override
    public void switchOff() {
        setLumen(0);
    }

    @Override
    public boolean isSwitchedOn() {
        return lumen > 0;
    }

    @Override
    public boolean isSwitchedOff() {
        return lumen <= 0;
    }
}
