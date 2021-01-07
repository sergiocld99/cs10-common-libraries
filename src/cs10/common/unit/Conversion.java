package cs10.common.unit;

public enum Conversion {
    ATM_PASCAL(101325),
    CELSIUS_KELVIN(273.15),
    FAHRENHEIT_OFFSET(32),
    FAHRENHEIT_INTERVAL(1.8),
    RANKINE_CELSIUS(491.67);

    private final double number;

    Conversion(double number){
        this.number = number;
    }

    public double getNumber() {
        return number;
    }
}
