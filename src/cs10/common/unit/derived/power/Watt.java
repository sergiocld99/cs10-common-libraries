package cs10.common.unit.derived.power;

import cs10.common.unit.Multiplier;

public class Watt extends Power {

    public Watt(){}

    public Watt(double value){
        this(value, null);
    }

    public Watt(double value, Multiplier multiplier) {
        setValue((multiplier != null ? multiplier.getMulti() : 1) * value);
    }

    @Override
    public KiloWatt getInKiloWatt() {
        return new KiloWatt(getValue() / Multiplier.KILO.getMulti());
    }

    @Override
    public String getAbbreviation() {
        return "W";
    }
}
