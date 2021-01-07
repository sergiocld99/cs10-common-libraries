package cs10.common.unit.derived.electric.potential;

public class Volt extends ElectricPotential {

    public Volt(){}

    public Volt(double value){
        setValue(value);
    }

    @Override
    public String getAbbreviation() {
        return "V";
    }
}
