package ch.hslu.oop.exercises.temperature;

import java.io.*;
import java.util.Scanner;

public class Demo {
    private static final String TemperaturePath = ".temperature_data.dat";
    public static void main(final String[] args) throws IOException {
        TemperaturVerlauf verlauf = CreateTemperatureVerlaufFromUserDirectory();
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

        SaveTemperatureVerlaufToUserDirectory(verlauf);

        System.out.println("Programm beendet.");
    }

    private static void SaveTemperatureVerlaufToUserDirectory(TemperaturVerlauf verlauf) throws IOException {
        var file = new File(TemperaturePath);
        file.createNewFile();
        try(var stream = new DataOutputStream(new FileOutputStream(file, false))){
            for (Temperature temperature:verlauf) {
                stream.writeFloat(temperature.getValue());
            }
        }

    }

    private static TemperaturVerlauf CreateTemperatureVerlaufFromUserDirectory() throws IOException {
        var verlauf = new TemperaturVerlauf();
        if(!new File(TemperaturePath).exists()){
            return verlauf;
        }

        try (var stream = new DataInputStream(new FileInputStream(TemperaturePath))){
            while(stream.available() > 0){
                verlauf.add(stream.readFloat());
            }
        }

        return verlauf;
    }
}
