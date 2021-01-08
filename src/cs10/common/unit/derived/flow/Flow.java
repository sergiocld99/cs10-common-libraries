package cs10.common.unit.derived.flow;

import cs10.common.unit.Unit;
import cs10.common.unit.base.time.Second;

public abstract class Flow extends Unit {

    protected abstract String getInternalAbbreviation();

    @Override
    public String getAbbreviation() {
        return getInternalAbbreviation() + "/" + Second.ABBREV;
    }

    @Override
    public String toString() {
        return getIdentifier() + " = " + getValue() + " " + getAbbreviation();
    }
}
