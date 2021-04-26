package ch.hslu.oop.exercises.temperature;

public class TemperatureBelowZeroKelvinException extends IllegalArgumentException{
    public TemperatureBelowZeroKelvinException(){
        super("Temperature cannot be below -" + Temperature.KelvinOffset + " Celsius");
    }
}
