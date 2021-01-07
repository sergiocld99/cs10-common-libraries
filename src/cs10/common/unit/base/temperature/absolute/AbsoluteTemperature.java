package cs10.common.unit.base.temperature.absolute;

import cs10.common.unit.base.temperature.Temperature;

public abstract class AbsoluteTemperature extends Temperature {

    @Override
    public char getIdentifier() {
        return 'T';
    }
}
