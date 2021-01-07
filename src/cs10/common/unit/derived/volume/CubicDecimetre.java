package cs10.common.unit.derived.volume;

import cs10.common.unit.Multiplied;
import cs10.common.unit.Multiplier;

public class CubicDecimetre extends CubicMetre implements Multiplied {

    public CubicDecimetre(boolean specific) {
        super(specific);
    }

    public CubicDecimetre(double value, boolean specific){
        this(specific);
        setValue(value);
    }

    public CubicDecimetre(CubicMetre cubicMetre){
        this(cubicMetre.isSpecific());
        int exponent = getMultiplier().getExponent() * Volume.EXPONENT;
        double multi = Math.pow(10, exponent);
        setValue(cubicMetre.getValue() / multi);
    }

    @Override
    public CubicMetre getInCubicMetre() {
        return new CubicMetre(getValue(), getMultiplier(), isSpecific());
    }

    @Override
    public Multiplier getMultiplier() {
        return Multiplier.DECI;
    }

    @Override
    public String getInternalAbbreviation() {
        return getMultiplier().getPrefix() + super.getInternalAbbreviation();
    }
}
