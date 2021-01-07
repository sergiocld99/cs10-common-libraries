package cs10.common.unit.derived.power;

import cs10.common.unit.Unit;

public abstract class Power extends Unit {

    public abstract KiloWatt getInKiloWatt();

    @Override
    public char getIdentifier() {
        return 'P';
    }
}
