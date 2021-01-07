package cs10.common.unit.derived.energy;

public class Joule extends Energy {

    public Joule(boolean specific) {
        super(specific);
    }

    public Joule(double value, boolean specific){
        this(specific);
        setValue(value);
    }

    @Override
    public String getInternalAbbreviation() {
        return "J";
    }
}
