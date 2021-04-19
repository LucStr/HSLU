package ch.hslu.oop.exercises.temperature;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TemperaturVerlaufTest {
    @Test
    public void testClear(){
       var verlauf = new TemperaturVerlauf();
       verlauf.add(new Temperature());

       assertEquals(1, verlauf.size());

       verlauf.clear();

       assertEquals(0, verlauf.size());
    }

    @Test
    public void testGetCount(){
        var verlauf = new TemperaturVerlauf();
        verlauf.add(new Temperature());

        assertEquals(1, verlauf.getCount());
        verlauf.add(new Temperature());

        assertEquals(2, verlauf.getCount());
    }

    @Test
    public void testMax(){
        var list = new TemperaturVerlauf();
        var maxTemp = new Temperature(11.5f);
        list.add(new Temperature(11.15f));
        list.add(maxTemp);
        list.add(new Temperature(9.15f));
        list.add(new Temperature(10f));

        assertEquals(maxTemp, Collections.max(list));
    }

    @Test
    public void testMin(){
        var list = new TemperaturVerlauf();
        var minTemp = new Temperature(9.15f);
        list.add(new Temperature(11.15f));
        list.add(minTemp);
        list.add(new Temperature(11.5f));
        list.add(new Temperature(10f));

        assertEquals(minTemp, Collections.min(list));
    }

    @Test
    public void testGetAverage(){
        var list = new TemperaturVerlauf();
        list.add(new Temperature(1));
        list.add(new Temperature(5));
        list.add(new Temperature(6));

        assertEquals(4, list.getAverage());
    }
}