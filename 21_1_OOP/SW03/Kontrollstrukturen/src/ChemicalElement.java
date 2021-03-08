public class ChemicalElement {
    private String symbol;
    private Temperature hardToLiquid;
    private Temperature liquidToGas;

    public ChemicalElement(String symbol, Temperature hardToLiquid, Temperature liquidToGas){
        this.symbol = symbol;
        this.hardToLiquid = hardToLiquid;
        this.liquidToGas = liquidToGas;
    }

    public ChemicalElement(String symbol, float hardToLiquid, float liquidToHard){
        this(symbol, new Temperature(hardToLiquid), new Temperature(liquidToHard));
    }

    public Temperature getHardToLiquid() {
        return hardToLiquid;
    }

    public Temperature getLiquidToGas() {
        return liquidToGas;
    }
}
