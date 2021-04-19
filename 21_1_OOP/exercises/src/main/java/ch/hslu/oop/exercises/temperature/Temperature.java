package ch.hslu.oop.exercises.temperature;

public final class Temperature implements Comparable<Temperature> {
    private float value;
    public static float KelvinOffset = (float) 273.15;

    public Temperature(){
        this.value = 20;
    }

    public Temperature(float value) {
        this(value, TemperatureType.Celsius);
    }
    public Temperature(float value, TemperatureType type){
        setValue(value, type);
    }
    public Temperature(Temperature temperature){
        this(temperature.value);
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

    public void setValue(float value) {
        this.value = value;
    }

    public void setValue(float value, TemperatureType type){
        switch (type){
            case Celsius:
                this.value = value;
                break;
            case Kelvin:
                this.value = value - KelvinOffset;
                break;
            case Fahrenheit:
                this.value = (value - 32) / 1.8f;
        }
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

