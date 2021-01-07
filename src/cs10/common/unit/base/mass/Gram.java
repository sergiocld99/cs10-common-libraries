package cs10.common.unit.base.mass;

public class Gram extends Mass {

    public Gram(){}

    public Gram(double value){
        setValue(value);
    }

    @Override
    public String getAbbreviation() {
        return "g";
    }
}
