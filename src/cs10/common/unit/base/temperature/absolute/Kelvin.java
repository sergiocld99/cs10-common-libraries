package cs10.common.unit.base.temperature.absolute;

import cs10.common.unit.Conversion;
import cs10.common.unit.base.temperature.relative.Celsius;

public class Kelvin extends AbsoluteTemperature {
    public static String ABBREV = "K";

    public Kelvin(){}

    public Kelvin(double value){
        setValue(value);
    }

    public Kelvin(Celsius celsius){
        setValue(celsius.getValue() + Conversion.CELSIUS_KELVIN.getNumber());
    }

    @Override
    public Celsius getInCelsius() {
        return new Celsius(this);
    }

    @Override
    public Kelvin getInKelvin() {
        return this;
    }

    @Override
    public String getAbbreviation() {
        return ABBREV;
    }
}
