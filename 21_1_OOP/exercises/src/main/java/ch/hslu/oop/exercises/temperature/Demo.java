package ch.hslu.oop.exercises.temperature;

import java.util.Scanner;

public class Demo {
    public static void main(final String[] args) {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        verlauf.addMaxEventListener(new LoggingTemperatureEventHandler());
        verlauf.addMinEventListener(new LoggingTemperatureEventHandler());

        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            if(input.trim().equals("exit")){
                break;
            }

            try{
                float value = Float.valueOf(input);
                var temperature = new Temperature(value);
                System.out.println(temperature);
                verlauf.add(temperature);
            } catch(NumberFormatException exception){
                System.out.println("Üngültige Eingabe!");
            } catch (TemperatureBelowZeroKelvinException exception){
                System.out.println("Die eingegebene Temperatur ist unter 0 Kelvin!");
            }
        } while (true);
        System.out.println("Programm beendet.");
    }
}
