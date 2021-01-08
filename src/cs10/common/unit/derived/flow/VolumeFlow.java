package cs10.common.unit.derived.flow;

import cs10.common.unit.base.length.Metre;
import cs10.common.unit.derived.volume.Volume;

public class VolumeFlow extends Flow {

    public VolumeFlow(){}

    public VolumeFlow(double value){
        setValue(value);
    }

    public VolumeFlow(MassFlow massFlow, Volume volume){
        if (!volume.isSpecific()) throw new IllegalArgumentException(volume + " is not specific");
        setValue(massFlow.getValue() * volume.getValue());
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
