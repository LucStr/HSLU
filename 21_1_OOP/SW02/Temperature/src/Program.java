public class Program {
    public static void main(String[] args){
        System.out.printf("Basic Temperature %.2f Celsius%n", new Temperature().getValue());
        System.out.printf("Basic Temperature %.2f Celsius%n", new Temperature(22.5321f).getValue());
        System.out.printf("Basic Temperature %.2f Kelvin%n", new Temperature().getValue(TemperatureType.Kelvin));
        System.out.printf("Basic Temperature %.2f Fahrenheit%n", new Temperature().getValue(TemperatureType.Fahrenheit));
        System.out.printf("Basic Temperature %.2f Celsius%n", new Temperature(293.15f, TemperatureType.Kelvin).getValue());
        System.out.printf("Basic Temperature %.2f Celsius%n", new Temperature(68f, TemperatureType.Fahrenheit).getValue());
    }
}
