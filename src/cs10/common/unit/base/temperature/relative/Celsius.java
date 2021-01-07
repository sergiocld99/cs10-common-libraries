package cs10.common.unit.base.temperature.relative;

import cs10.common.unit.Conversion;
import cs10.common.unit.base.temperature.absolute.Kelvin;
import cs10.common.unit.base.temperature.absolute.Rankine;

public class Celsius extends RelativeTemperature {

    public Celsius(){}

    public Celsius(double value){
        setValue(value);
    }

    public Celsius(Fahrenheit fahrenheit){
        setValue((fahrenheit.getValue() - Conversion.FAHRENHEIT_OFFSET.getNumber()) /
                Conversion.FAHRENHEIT_INTERVAL.getNumber());
    }

    public Celsius(Kelvin kelvin){
        setValue(kelvin.getValue() - Conversion.CELSIUS_KELVIN.getNumber());
    }

    public Celsius(Rankine rankine){
        setValue((rankine.getValue() - Conversion.RANKINE_CELSIUS.getNumber()) /
                Conversion.FAHRENHEIT_INTERVAL.getNumber());
    }

    @Override
    public Celsius getInCelsius() {
        return this;
    }

    @Override
    protected char getLetter() {
        return 'C';
    }
}
