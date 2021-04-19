package ch.hslu.oop.exercises.temperature;

import java.util.*;

public class TemperaturVerlauf extends ArrayList<Temperature> {
    public int getCount(){
        return this.size();
    }

    public float getAverage(){
        var sum = 0f;

        for (final Temperature temperature: this) {
            sum += temperature.getValue();
        }

        return sum / this.size();
    }
}
