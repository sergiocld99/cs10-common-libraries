package cs10.common.unit.derived.volume;

import cs10.common.unit.derived.SpecificUnit;

public abstract class Volume extends SpecificUnit {
    public static final int EXPONENT = 3;

    public Volume(boolean specific) {
        super(specific);
    }

    public abstract CubicMetre getInCubicMetre();

    @Override
    public char getIdentifier() {
        if (isSpecific()) return 'v';
        else return 'V';
    }
}
