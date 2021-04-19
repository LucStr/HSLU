package ch.hslu.oop.exercises.temperature;

import java.text.DecimalFormat;
import java.util.HashMap;

public abstract class ChemicalElement {
    private String symbol;
    private String humanReadableName;
    private Temperature hardToLiquid;
    private Temperature liquidToGas;

    public ChemicalElement(String symbol, Temperature hardToLiquid, Temperature liquidToGas){
        this.symbol = symbol;
        this.hardToLiquid = hardToLiquid;
        this.liquidToGas = liquidToGas;
    }

    public ChemicalElement(String symbol, String humanReadableName, Temperature hardToLiquid, Temperature liquidToGas){
        this(symbol, hardToLiquid, liquidToGas);
        this.humanReadableName = humanReadableName;
    }

    public ChemicalElement(String symbol, float hardToLiquid, float liquidToHard){
        this(symbol, new Temperature(hardToLiquid), new Temperature(liquidToHard));
    }

    public ChemicalElement(String symbol, String humanReadableName, float hardToLiquid, float liquidToGas){
        this(symbol, hardToLiquid, liquidToGas);
        this.humanReadableName = humanReadableName;
    }

    public Temperature getHardToLiquid() {
        return hardToLiquid;
    }

    public Temperature getLiquidToGas() {
        return liquidToGas;
    }

    @Override
    public String toString() {
        return symbol;
    }

    private String getReadableAggregation(Aggregation aggregation){
        var map = new HashMap<Aggregation, String>();
        map.put(Aggregation.SOLID, "fest");
        map.put(Aggregation.LIQUID, "flüssig");
        map.put(Aggregation.GAS, "gasförmig");

        return map.get(aggregation);
    }

    public String getStateAtTemperature(Temperature temperature){
        var state = temperature.getStateOfAggregationForElementByChemicalElement(this);

        var readableState = getReadableAggregation(state);

        return this.humanReadableName + " ist bei " + new DecimalFormat("#.00").format(temperature.getValue()) + "°C " + readableState + ".";
    }
}
