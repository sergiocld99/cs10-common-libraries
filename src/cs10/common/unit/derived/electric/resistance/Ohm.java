package cs10.common.unit.derived.electric.resistance;

public class Ohm extends ElectricResistance {

    public Ohm(){}

    public Ohm(double value){
        setValue(value);
    }

    @Override
    public String getAbbreviation() {
        return "Ω";
    }
}
