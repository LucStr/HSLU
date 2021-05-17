package ch.hslu.oop.exercises.temperature;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.TimeZone;

public class ImportFromCsv {
    private static final String ImportFileName = "netatmo-export-201801-201804.csv";
    public static void main(final String[] args){
        var importFile = new File(ImportFileName);
        if(!importFile.exists()){
            System.out.println("Please add the file " + ImportFileName);
            return;
        }

        var messungenVerlauf = new MessungenVerlauf();
        try(var reader = new BufferedReader(new FileReader(ImportFileName))){
            var line = reader.readLine();
            while(line != null){
                var values = line.split(";");
                var timestamp = LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(Long.parseLong(values[0])), TimeZone.getDefault().toZoneId());
                messungenVerlauf.add(new Messung(timestamp, new Temperature(Float.parseFloat(values[2]))));

                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        var max = Collections.max(messungenVerlauf);
        System.out.println("Die höchste Messung war " + max);

        var min = Collections.min(messungenVerlauf);
        System.out.println("Die tiefste Messung war " + min);

        var average = messungenVerlauf.getAverage();
        System.out.println("Die durchschnittliche Messung war " + average);
    }
}
