public class Temperature {
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
}

