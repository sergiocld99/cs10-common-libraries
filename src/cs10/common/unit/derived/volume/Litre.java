package cs10.common.unit.derived.volume;

public class Litre extends CubicDecimetre {

    public Litre(boolean specific){
        super(specific);
    }

    public Litre(double value, boolean specific){
        this(specific);
        setValue(value);
    }

    public Litre(CubicDecimetre cubicDecimetre){
        this(cubicDecimetre.getValue(), cubicDecimetre.isSpecific());
    }

    public Litre(CubicMetre cubicMetre){
        this(new CubicDecimetre(cubicMetre));
    }

    @Override
    public String getInternalAbbreviation() {
        return "L";
    }
}
