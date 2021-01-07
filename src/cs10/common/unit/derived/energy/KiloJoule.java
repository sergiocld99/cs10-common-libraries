package cs10.common.unit.derived.energy;

import cs10.common.unit.Multiplied;
import cs10.common.unit.Multiplier;

public class KiloJoule extends Joule implements Multiplied {

    public KiloJoule(boolean specific) {
        super(specific);
    }

    public KiloJoule(double value, boolean specific){
        this(specific);
        setValue(value);
    }

    public KiloJoule(Joule joule, boolean specific){
        this(specific);
        setValue(joule.getValue() / getMultiplier().getMulti());
    }

    @Override
    public Multiplier getMultiplier() {
        return Multiplier.KILO;
    }

    @Override
    public String getInternalAbbreviation() {
        return getMultiplier().getPrefix() + super.getInternalAbbreviation();
    }

    @Override
    public String toString() {
        return getIdentifier() + " = " + getValue() + " " + getAbbreviation();
    }
}
