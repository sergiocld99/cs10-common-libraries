package cs10.common.unit.base.temperature.relative;

import cs10.common.unit.base.temperature.Temperature;

public abstract class RelativeTemperature extends Temperature {

    protected abstract char getLetter();

    @Override
    public String getAbbreviation() {
        return "°" + getLetter();
    }

    @Override
    public char getIdentifier() {
        return 't';
    }
}
