package ch.hslu.oop.exercises.temperature;

public class LoggingTemperatureEventHandler extends TemperatureEventHandler {
    @Override
    public void handle(TemperaturVerlauf.TemperatureHoldingEvent event) {
        System.out.println(event);
    }
}
