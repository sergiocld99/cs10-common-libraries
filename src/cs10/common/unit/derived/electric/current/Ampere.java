package cs10.common.unit.derived.electric.current;

public class Ampere extends ElectricCurrent {

    public Ampere(){}

    public Ampere(double value){
        setValue(value);
    }

    @Override
    public String getAbbreviation() {
        return "A";
    }
}
