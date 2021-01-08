package cs10.common.unit.base.temperature;

import cs10.common.unit.Unit;
import cs10.common.unit.base.temperature.absolute.Kelvin;
import cs10.common.unit.base.temperature.relative.Celsius;

/**
 * @author Calderon Sergio Leandro
 * @version 3
 */
public abstract class Temperature extends Unit {

    public abstract Celsius getInCelsius();
    public abstract Kelvin getInKelvin();

    @Override
    public String toString() {
        return getIdentifier() + " = " + getValue() + " " + getAbbreviation();
    }
}
