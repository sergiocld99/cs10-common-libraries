package cs10.common.unit.derived.pressure;

import cs10.common.unit.Multiplier;
import cs10.common.unit.Multiplied;

public class MegaPascal extends Pascal implements Multiplied {

    public MegaPascal(){}

    public MegaPascal(double value){
        setValue(value);
    }

    public MegaPascal(KiloPascal kiloPascal){
        int exponent = kiloPascal.getMultiplier().getExponent() - getMultiplier().getExponent();
        double multi = Math.pow(10, exponent);
        setValue(kiloPascal.getValue() * multi);
    }

    @Override
    public KiloPascal getInKiloPascal() {
        return new KiloPascal(getValue(), getMultiplier());
    }

    @Override
    public Multiplier getMultiplier(){
        return Multiplier.MEGA;
    }

    @Override
    public String getAbbreviation() {
        return getMultiplier().getPrefix() + super.getAbbreviation();
    }

    @Override
    public String toString() {
        return getIdentifier() + " = " + getValue() + " " + getAbbreviation();
    }
}
