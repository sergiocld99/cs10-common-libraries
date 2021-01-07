package cs10.common.unit.derived.energy;

public class Enthalpy extends KiloJoule {

    public Enthalpy(boolean specific) {
        super(specific);
    }

    public Enthalpy(double value, boolean specific){
        super(value, specific);
    }

    @Override
    public char getIdentifier() {
        if (isSpecific()) return 'h';
        else return 'H';
    }
}
