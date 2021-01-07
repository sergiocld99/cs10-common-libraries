package cs10.common.unit.derived.entropy;

import cs10.common.unit.base.temperature.absolute.Kelvin;
import cs10.common.unit.derived.SpecificUnit;

public class Entropy extends SpecificUnit {

    public Entropy(boolean specific) {
        super(specific);
    }

    public Entropy(double value, boolean specific){
        this(specific);
        setValue(value);
    }

    @Override
    public char getIdentifier() {
        if (isSpecific()) return 's';
        else return 'S';
    }

    @Override
    protected String getInternalAbbreviation() {
        return "kJ";
    }

    @Override
    public String getAbbreviation() {
        return super.getAbbreviation() + "." + Kelvin.ABBREV;
    }
}
