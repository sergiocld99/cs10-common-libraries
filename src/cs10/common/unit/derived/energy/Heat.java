package cs10.common.unit.derived.energy;

public class Heat extends Enthalpy {

    public Heat(boolean specific) {
        super(specific);
    }

    public Heat(double value, boolean specific) {
        super(value, specific);
    }

    @Override
    public char getIdentifier() {
        return (isSpecific() ? 'q' : 'Q');
    }
}
