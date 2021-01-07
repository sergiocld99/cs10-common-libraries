package cs10.common.unit.derived.power;

import cs10.common.unit.Multiplied;
import cs10.common.unit.Multiplier;

public class KiloWatt extends Watt implements Multiplied {

    public KiloWatt() {}

    public KiloWatt(double value) {
        super(value);
    }

    @Override
    public KiloWatt getInKiloWatt() {
        return this;
    }

    @Override
    public Multiplier getMultiplier() {
        return Multiplier.KILO;
    }

    @Override
    public String getAbbreviation() {
        return getMultiplier().getPrefix() + super.getAbbreviation();
    }
}
