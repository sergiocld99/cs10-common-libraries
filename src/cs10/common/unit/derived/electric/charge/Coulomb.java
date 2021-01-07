package cs10.common.unit.derived.electric.charge;

public class Coulomb extends ElectricCharge {

    public Coulomb(){}

    public Coulomb(double value){
        setValue(value);
    }

    @Override
    public String getAbbreviation() {
        return "C";
    }
}
