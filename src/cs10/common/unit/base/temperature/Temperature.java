package cs10.common.unit.base.temperature;

import cs10.common.unit.Unit;
import cs10.common.unit.base.temperature.relative.Celsius;

/**
 * @author Calderon Sergio Leandro
 * @version 2
 */
public abstract class Temperature extends Unit {

    public abstract Celsius getInCelsius();

    @Override
    public String toString() {
        return getIdentifier() + " = " + getValue() + " " + getAbbreviation();
    }
}
