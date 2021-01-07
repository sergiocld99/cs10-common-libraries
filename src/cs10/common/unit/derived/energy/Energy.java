package cs10.common.unit.derived.energy;

import cs10.common.unit.derived.SpecificUnit;

public abstract class Energy extends SpecificUnit {

    public Energy(boolean specific) {
        super(specific);
    }

    @Override
    public char getIdentifier() {
        return 'E';
    }
}
