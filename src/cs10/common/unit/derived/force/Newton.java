package cs10.common.unit.derived.force;

public class Newton extends Force {

    public Newton(){}

    public Newton(double value){
        setValue(value);
    }

    @Override
    public String getAbbreviation() {
        return "N";
    }
}
