package cs10.common.unit.derived.flow;

import cs10.common.unit.base.length.Metre;
import cs10.common.unit.derived.volume.Volume;

public class VolumeFlow extends Flow {

    public VolumeFlow(){}

    public VolumeFlow(double value){
        setValue(value);
    }

    /**
     * @param massFlow a mass flow in kg/s
     * @param volume a specific volume
     * @throws IllegalArgumentException if volume is not specific
     */
    public VolumeFlow(MassFlow massFlow, Volume volume) throws IllegalArgumentException {
        if (!volume.isSpecific()) throw new IllegalArgumentException(volume + " is not specific");
        setValue(massFlow.getValue() * volume.getInCubicMetre().getValue());
    }

    @Override
    public char getIdentifier() {
        return 'V';
    }

    @Override
    protected String getInternalAbbreviation() {
        return Metre.ABBREV + Volume.EXPONENT;
    }
}
