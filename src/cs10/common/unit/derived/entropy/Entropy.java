package cs10.common.unit.derived.entropy;

import cs10.common.unit.base.temperature.Temperature;
import cs10.common.unit.base.temperature.absolute.Kelvin;
import cs10.common.unit.derived.SpecificUnit;
import cs10.common.unit.derived.energy.Heat;

/**
 * @author Calderon Sergio Leandro
 * @version 3
 */
public class Entropy extends SpecificUnit {

    public Entropy(boolean specific) {
        super(specific);
    }

    public Entropy(double value, boolean specific){
        this(specific);
        setValue(value);
    }

    /**
     * @param heat heat from hot source (negative) or to cold sink (positive)
     * @param kelvin temperature of hot source or cold sink
     */
    public Entropy(Heat heat, Kelvin kelvin){
        this(heat.getValue() / kelvin.getValue(), true);
    }

    public Entropy(Heat heat, Temperature temperature){
        this(heat, temperature.getInKelvin());
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
