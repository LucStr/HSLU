package ch.hslu.oop.exercises.temperature;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void getValueDefault() {
        var t = new Temperature(10);

        assertEquals(10, t.getValue());
    }

    @Test
    void getValueCelsius() {
        var t = new Temperature(10, TemperatureType.Celsius);

        assertEquals(10, t.getValue(TemperatureType.Celsius));
    }

    @Test
    void getValueKelvin() {
        var t = new Temperature(10, TemperatureType.Kelvin);

        assertEquals(10, t.getValue(TemperatureType.Kelvin));
    }

    @Test
    void getValueFahrenheit() {
        var t = new Temperature(10, TemperatureType.Fahrenheit);

        assertEquals(10, t.getValue(TemperatureType.Fahrenheit));
    }

    @Test
    void convertKelvinToCelsius() {
        assertEquals(-263.15f, Temperature.convertKelvinToCelsius(10));

    }

    @Test
    void convertCelsiusToKelvin() {
        assertEquals(283.15f, Temperature.convertCelsiusToKelvin(10));
    }

    @Test
    void testCompareTo() {
        var list = new ArrayList<Temperature>();
        var maxTemp = new Temperature(11.5f);
        list.add(new Temperature(11.15f));
        list.add(maxTemp);
        list.add(new Temperature(9.15f));
        list.add(new Temperature(10f));

        assertEquals(maxTemp, Collections.max(list));
    }

    @Test
    void exceptionForTemperatureBelowKelvin(){
        Exception thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Temperature(-1, TemperatureType.Kelvin),
                "Expected Constructor to throw if temperature below 0 Kelvin is given"
        );
    }

    @Test
    void noExceptionForTemperatureAtZeroKelvin(){
        new Temperature(0, TemperatureType.Kelvin);
    }
}