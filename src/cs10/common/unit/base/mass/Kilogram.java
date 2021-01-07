package cs10.common.unit.base.mass;

import cs10.common.unit.Multiplied;
import cs10.common.unit.Multiplier;

public class Kilogram extends Gram implements Multiplied {

    public Kilogram(){}

    public Kilogram(double value){
        setValue(value);
    }

    @Override
    public Multiplier getMultiplier() {
        return Multiplier.KILO;
    }

    @Override
    public String getAbbreviation() {
        return Multiplier.KILO.getPrefix() + super.getAbbreviation();
    }
}
