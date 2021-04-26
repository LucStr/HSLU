package ch.hslu.oop.exercises.exceptions;

import ch.hslu.oop.exercises.temperature.Temperature;
import ch.hslu.oop.exercises.temperature.TemperatureBelowZeroKelvinException;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
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
                System.out.println(new Temperature(value));
            } catch(NumberFormatException exception){
                System.out.println("Üngültige Eingabe!");
            } catch (TemperatureBelowZeroKelvinException exception){
                System.out.println("Die eingegebene Temperatur ist unter 0 Kelvin!");
            }
        } while (true);
        System.out.println("Programm beendet.");
    }
}
