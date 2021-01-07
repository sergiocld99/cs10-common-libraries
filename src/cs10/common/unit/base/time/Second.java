package cs10.common.unit.base.time;

public class Second extends Time {
    public static final String ABBREV = "s";

    public Second(){}

    public Second(double value){
        setValue(value);
    }

    @Override
    public String getAbbreviation() {
        return ABBREV;
    }
}
