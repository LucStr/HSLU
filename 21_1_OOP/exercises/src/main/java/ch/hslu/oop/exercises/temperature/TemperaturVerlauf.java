package ch.hslu.oop.exercises.temperature;

import java.util.*;

public class TemperaturVerlauf extends ArrayList<Temperature> {
    private List<TemperatureEventHandler> minEventListeners = new ArrayList<TemperatureEventHandler>();
    private List<TemperatureEventHandler> maxEventListeners = new ArrayList<TemperatureEventHandler>();;

    @Override
    public boolean add(Temperature temperature){
        var oldMin = this.size() > 0 ? Collections.min(this) : null;
        var oldMax = this.size() > 0 ? Collections.max(this) : null;

        var result = super.add(temperature);
        if(!result){
            return false;
        }

        if(oldMin != Collections.min(this)){
            for (TemperatureEventHandler listener : minEventListeners) {
                listener.handle(new MinTemperatureEvent(this, Collections.min(this)));
            }
        }
        if(oldMax != Collections.max(this)){
            for (TemperatureEventHandler listener : maxEventListeners) {
                listener.handle(new MaxTemperatureEvent(this, Collections.max(this)));
            }
        }

        return true;
    }

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

    public void addMinEventListener(TemperatureEventHandler listener){
        minEventListeners.add(listener);
    }

    public void addMaxEventListener(TemperatureEventHandler listener){
        maxEventListeners.add(listener);
    }

    public abstract class TemperatureHoldingEvent extends EventObject{
        protected Temperature temperature;

        /**
         * Constructs a prototypical Event.
         *
         * @param source the object on which the Event initially occurred
         * @param temperature
         * @throws IllegalArgumentException if source is null
         */
        public TemperatureHoldingEvent(Object source, Temperature temperature) {
            super(source);
            this.temperature = temperature;
        }
    }

    public class MaxTemperatureEvent extends TemperatureHoldingEvent{
        /**
         * Constructs a prototypical Event.
         *
         * @param source      the object on which the Event initially occurred
         * @param temperature
         * @throws IllegalArgumentException if source is null
         */
        public MaxTemperatureEvent(Object source, Temperature temperature) {
            super(source, temperature);
        }

        @Override
        public String toString(){
            return "Neuer Max Temperatur Event: " + temperature.toString();
        }
    }

    public class MinTemperatureEvent extends TemperatureHoldingEvent{

        /**
         * Constructs a prototypical Event.
         *
         * @param source      the object on which the Event initially occurred
         * @param temperature
         * @throws IllegalArgumentException if source is null
         */
        public MinTemperatureEvent(Object source, Temperature temperature) {
            super(source, temperature);
        }

        @Override
        public String toString(){
            return "Neuer Min Temperatur Event: " + temperature.toString();
        }
    }
}

