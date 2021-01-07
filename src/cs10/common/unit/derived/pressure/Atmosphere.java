package cs10.common.unit.derived.pressure;

import cs10.common.unit.Conversion;

public class Atmosphere extends Pressure {

    public Atmosphere(){}

    public Atmosphere(Pascal pascal){
        setValue(pascal.getValue() / Conversion.ATM_PASCAL.getNumber());
    }

    @Override
    public KiloPascal getInKiloPascal() {
        return new KiloPascal(new Pascal(this));
    }

    @Override
    public String getAbbreviation() {
        return "atm";
    }
}
