package cs10.common.unit.derived.pressure;

import cs10.common.unit.Conversion;
import cs10.common.unit.Multiplier;

public class Pascal extends Pressure {

    public Pascal(){}

    public Pascal(double value){
        this(value, null);
    }

    public Pascal(Atmosphere atmosphere){
        this(atmosphere.getValue() * Conversion.ATM_PASCAL.getNumber());
    }

    public Pascal(double value, Multiplier multiplier){
        setValue(value * (multiplier != null ? multiplier.getMulti() : 1));
    }

    @Override
    public KiloPascal getInKiloPascal() {
        return new KiloPascal(this);
    }

    @Override
    public String getAbbreviation() {
        return "Pa";
    }
}
