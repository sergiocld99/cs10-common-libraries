package cs10.common.unit.derived;

import cs10.common.unit.Unit;

public abstract class SpecificUnit extends Unit {
    private final boolean specific;

    public SpecificUnit(boolean specific) {
        this.specific = specific;
    }

    public boolean isSpecific() {
        return specific;
    }

    protected abstract String getInternalAbbreviation();

    @Override
    public String getAbbreviation() {
        return getInternalAbbreviation() + (isSpecific() ? "/kg" : "");
    }
}
