package cs10.common.unit.base.temperature.absolute;

import cs10.common.unit.Conversion;
import cs10.common.unit.base.temperature.relative.Celsius;

public class Rankine extends AbsoluteTemperature {

    public Rankine(){}

    public Rankine(double value){
        setValue(value);
    }

    public Rankine(Kelvin kelvin){
        setValue(kelvin.getValue() * Conversion.FAHRENHEIT_INTERVAL.getNumber());
    }

    public Rankine(Celsius celsius){
        this(new Kelvin(celsius));
    }

    @Override
    public Kelvin getInKelvin() {
        return new Kelvin(new Celsius(this));
    }

    @Override
    public Celsius getInCelsius() {
        return new Celsius(this);
    }

    @Override
    public String getAbbreviation() {
        return "°R";
    }
}
