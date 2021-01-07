package cs10.common.unit.base.temperature;

import cs10.common.unit.Unit;
import cs10.common.unit.base.temperature.relative.Celsius;

public abstract class Temperature extends Unit {

    public abstract Celsius getInCelsius();
}
