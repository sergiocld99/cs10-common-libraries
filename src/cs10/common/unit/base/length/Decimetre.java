package cs10.common.unit.base.length;

import cs10.common.unit.Multiplied;
import cs10.common.unit.Multiplier;

public class Decimetre extends Metre implements Multiplied {

    public Decimetre(){}

    public Decimetre(double value){
        setValue(value);
    }

    public Decimetre(Metre metre){
        setValue(metre.getValue() / getMultiplier().getMulti());
    }

    @Override
    public Multiplier getMultiplier() {
        return Multiplier.DECI;
    }

    @Override
    public String getAbbreviation() {
        return getMultiplier().getPrefix() + super.getAbbreviation();
    }
}
