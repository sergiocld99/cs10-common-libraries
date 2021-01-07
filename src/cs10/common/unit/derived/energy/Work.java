package cs10.common.unit.derived.energy;

public class Work extends Enthalpy {

    public Work(boolean specific) {
        super(specific);
    }

    public Work(double value, boolean specific) {
        super(value, specific);
    }

    @Override
    public char getIdentifier() {
        return (isSpecific() ? 'w' : 'W');
    }
}
