package cs10.common.unit.base.length;

public class Metre extends Length {
    public static final String ABBREV = "m";

    public Metre(){}

    public Metre(double value){
        setValue(value);
    }

    @Override
    public String getAbbreviation() {
        return ABBREV;
    }
}
