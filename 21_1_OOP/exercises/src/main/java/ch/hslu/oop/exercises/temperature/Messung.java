package ch.hslu.oop.exercises.temperature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Messung implements Comparable<Messung>  {
    private final LocalDateTime timestamp;
    private final Temperature temperature;

    public Messung(LocalDateTime timestamp, Temperature temperature){
        this.timestamp = timestamp;
        this.temperature = temperature;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public int compareTo(Messung otherMessung) {
        return this.temperature.compareTo(otherMessung.temperature);
    }

    @Override
    public String toString(){
        return this.temperature.toString() + " at " + DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss").format(this.timestamp);
    }
}
