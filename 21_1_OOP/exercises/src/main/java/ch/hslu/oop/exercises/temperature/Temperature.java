package ch.hslu.oop.exercises.temperature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Temperature implements Comparable<Temperature> {
    private float value;
    public static float KelvinOffset = (float) 273.15;
    static Logger log = LogManager.getLogger(Temperature.class);

    public Temperature(){
        this.value = 20;
    }

    public Temperature(final float value) {
        this(value, TemperatureType.Celsius);
    }
    public Temperature(final float value, TemperatureType type){
        setValue(value, type);
    }
    public Temperature(final Temperature temperature){
        this(temperature.value);
    }

    public static Temperature createFromCelsius(final float celsius){
        return new Temperature(celsius);
    }

    public static Temperature createFromKelvin(final float kelvin){
        return new Temperature(kelvin, TemperatureType.Kelvin);
    }

    public float getValue(TemperatureType type) {
        float value = 0;
        switch (type){
            case Celsius:
                value = this.value;
                break;
            case Kelvin:
                value = this.value + KelvinOffset;
                break;
            case Fahrenheit:
                value = this.value * 1.8f + 32;
        }

        return value;
    }

    public float getValue() {
        return value;
    }

    private void setValue(final float value) {
        this.value = value;
    }

    private void setValue(float value, TemperatureType type) throws TemperatureBelowZeroKelvinException{
        switch (type){
            case Kelvin:
                value = value - KelvinOffset;
                break;
            case Fahrenheit:
                value = (value - 32) / 1.8f;
        }

        if(value < -KelvinOffset){
            var exception = new TemperatureBelowZeroKelvinException();
            log.error(exception);

            throw exception;
        }

        this.value = value;
    }

    public Aggregation getStateOfAggregationForElementByChemicalElement(ChemicalElement element){
        if(element.getHardToLiquid().getValue() > value){
            return Aggregation.SOLID;
        }

        return element.getLiquidToGas().getValue() > value ? Aggregation.LIQUID : Aggregation.GAS;
    }

    @Override
    public int compareTo(Temperature otherTemperature) {
        return Float.compare(value, otherTemperature.value);
    }

    @Override
    public String toString(){
        return this.value + " Celsius";
    }

    public static float convertKelvinToCelsius(float kelvin){
        return new Temperature(kelvin, TemperatureType.Kelvin).getValue();
    }

    public static float convertCelsiusToKelvin(float celsius){
        return new Temperature(celsius, TemperatureType.Celsius).getValue(TemperatureType.Kelvin);
    }
}

