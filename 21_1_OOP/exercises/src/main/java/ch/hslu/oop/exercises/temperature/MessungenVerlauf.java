package ch.hslu.oop.exercises.temperature;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.List;

public class MessungenVerlauf extends ArrayList<Messung> {
    private List<MessungEventHandler> minEventListeners = new ArrayList<MessungEventHandler>();
    private List<MessungEventHandler> maxEventListeners = new ArrayList<MessungEventHandler>();

    public boolean add(float temperature){
        return add(new Temperature(temperature));
    }

    public boolean add(Temperature temperature){
        return add(new Messung(LocalDateTime.now(), temperature));
    }

    @Override
    public boolean add(Messung messung){
        var oldMin = this.size() > 0 ? Collections.min(this) : null;
        var oldMax = this.size() > 0 ? Collections.max(this) : null;

        var result = super.add(messung);
        if(!result){
            return false;
        }

        if(oldMin != Collections.min(this)){
            for (MessungEventHandler listener : minEventListeners) {
                listener.handle(new MinMessungEvent(this, Collections.min(this)));
            }
        }
        if(oldMax != Collections.max(this)){
            for (MessungEventHandler listener : maxEventListeners) {
                listener.handle(new MaxMessungEvent(this, Collections.max(this)));
            }
        }

        return true;
    }

    public int getCount(){
        return this.size();
    }

    public float getAverage(){
        var sum = 0f;

        for (final Messung messung: this) {
            sum += messung.getTemperature().getValue();
        }

        return sum / this.size();
    }

    public void addMinEventListener(MessungEventHandler listener){
        minEventListeners.add(listener);
    }

    public void addMaxEventListener(MessungEventHandler listener){
        maxEventListeners.add(listener);
    }

    public abstract class MessungHoldingEvent extends EventObject{
        protected Messung messung;

        /**
         * Constructs a prototypical Event.
         *
         * @param source the object on which the Event initially occurred
         * @param messung
         * @throws IllegalArgumentException if source is null
         */
        public MessungHoldingEvent(Object source, Messung messung) {
            super(source);
            this.messung = messung;
        }
    }

    public class MaxMessungEvent extends MessungHoldingEvent {
        /**
         * Constructs a prototypical Event.
         *
         * @param source      the object on which the Event initially occurred
         * @param messung
         * @throws IllegalArgumentException if source is null
         */
        public MaxMessungEvent(Object source, Messung messung) {
            super(source, messung);
        }

        @Override
        public String toString(){
            return "Neuer Max Temperatur Event: " + messung.toString();
        }
    }

    public class MinMessungEvent extends MessungHoldingEvent {

        /**
         * Constructs a prototypical Event.
         *
         * @param source      the object on which the Event initially occurred
         * @param messung
         * @throws IllegalArgumentException if source is null
         */
        public MinMessungEvent(Object source, Messung messung) {
            super(source, messung);
        }

        @Override
        public String toString(){
            return "Neuer Min Temperatur Event: " + messung.toString();
        }
    }
}

