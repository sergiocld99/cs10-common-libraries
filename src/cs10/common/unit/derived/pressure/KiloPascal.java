package cs10.common.unit.derived.pressure;

import cs10.common.unit.Multiplier;
import cs10.common.unit.Multiplied;

public class KiloPascal extends Pascal implements Multiplied {

    public KiloPascal(){}

    public KiloPascal(double value){
        setValue(value);
    }

    public KiloPascal(double value, Multiplier multiplier){
        double multi = Math.pow(10, multiplier.getExponent() - getMultiplier().getExponent());
        setValue(value * multi);
    }

    public KiloPascal(Pascal pascal){
        setValue(pascal.getValue() / getMultiplier().getMulti());
    }

    @Override
    public KiloPascal getInKiloPascal() {
        return this;
    }

    @Override
    public Multiplier getMultiplier(){
        return Multiplier.KILO;
    }

    @Override
    public String getAbbreviation() {
        return getMultiplier().getPrefix() + super.getAbbreviation();
    }

    @Override
    public String toString() {
        return getIdentifier() + " = " + getValue() + " " + getAbbreviation();
    }
}
