package cs10.common.unit.derived.flow;

import cs10.common.unit.Unit;
import cs10.common.unit.derived.energy.Enthalpy;
import cs10.common.unit.derived.power.Power;

/**
 * @author Calderon Sergio Leandro
 * @version 2
 */
public class MassFlow extends Flow {

    public MassFlow(){}

    public MassFlow(double value){
        setValue(value);
    }

    public MassFlow(Power power, Enthalpy work){
        this(power.getInKiloWatt().getValue() / work.getValue());
    }

    public MassFlow(double fraction, MassFlow total){
        this(fraction * total.getValue());
    }

    @Override
    protected String getInternalAbbreviation() {
        return "kg";
    }

    @Override
    public char getIdentifier() {
        return 'M';
    }
}
