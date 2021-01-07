package cs10.common.unit.derived.area;

import cs10.common.unit.base.length.Metre;

public class SquareMetre extends Area {

    public SquareMetre(){}

    public SquareMetre(double value){
        setValue(value);
    }

    @Override
    public String getAbbreviation() {
        return Metre.ABBREV + getExponent();
    }
}
