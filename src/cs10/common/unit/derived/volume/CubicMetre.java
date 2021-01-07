package cs10.common.unit.derived.volume;

import cs10.common.unit.Multiplier;
import cs10.common.unit.base.length.Metre;

public class CubicMetre extends Volume {

    public CubicMetre(boolean specific) {
        super(specific);
    }

    public CubicMetre(double value, boolean specific){
        this(specific);
        setValue(value);
    }

    public CubicMetre(double value, Multiplier multiplier, boolean specific){
        this(specific);
        int exponent = multiplier.getExponent() * Volume.EXPONENT;
        double multi = Math.pow(10, exponent);
        setValue(value * multi);
    }

    @Override
    public CubicMetre getInCubicMetre() {
        return this;
    }

    @Override
    public String getInternalAbbreviation() {
        return Metre.ABBREV + Volume.EXPONENT;
    }
}
