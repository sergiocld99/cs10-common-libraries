package cs10.common.unit.derived.pressure;

import cs10.common.unit.Unit;

public abstract class Pressure extends Unit {

    public abstract KiloPascal getInKiloPascal();

    @Override
    public char getIdentifier() {
        return 'p';
    }
}
