/**
 * The {@code Temperature} class is used to represent a Temperature
 */
public class Temperature {
    /**
     * The value is used to store the temperature in Celsius format
     */
    private float value;
    /**
     * This static float is used to represent the Offset Kelvin has to the Celsius temeprature
     * It is used for calcuation.
     */
    public static float KelvinOffset = (float) 273.15;

    /**
     * By Default a new Temperature will be at a cool 20 Degrees Celsius
     */
    public Temperature(){
        this.value = 20;
    }

    /**
     * This constructor allows to set an initial Celsius value
     * @param value
     * The Celsius value to be passed
     */
    public Temperature(float value) {
        this(value, TemperatureType.Celsius);
    }

    /**
     * This constructor allows to set a value with a specific type
     * @param value
     * The value
     * @param type
     * The Temperature Type that corresponds to the value
     */
    public Temperature(float value, TemperatureType type){
        setValue(value, type);
    }

    /**
     * Returns the value in the desired Temperature Type
     * @param type A {@code TemperatureType}
     * @return the value in the desired Temperature Type
     */
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

    /**
     * Returns the Temperature in Celsius
     * @return {@code float} representing the temperature in Celsius
     */
    public float getValue() {
        return value;
    }

    /**
     * Sets the value in Celsius
     * @param value the value
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * Sets the value with a specified Temperature Type
     * @param value A {@code float} representing the value
     * @param type A {@code TemperatureType} representing the Temperature Type
     */
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
}

