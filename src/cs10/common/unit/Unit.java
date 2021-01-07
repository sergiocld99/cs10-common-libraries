package cs10.common.unit;

public abstract class Unit {
    private Double value;

    public final boolean isSet(){
        return value != null;
    }

    public final double getValue() {
        return value;
    }

    public final void setValue(double value) {
        this.value = value;
    }

    public abstract String getAbbreviation();
    public abstract char getIdentifier();

    @Override
    public String toString() {
        double auxValue;
        String auxAbbreviation;

        if (value > Multiplier.MEGA.getMulti()){
            auxValue = value / Multiplier.MEGA.getMulti();
            auxAbbreviation = Multiplier.MEGA.getPrefix() + getAbbreviation();
        } else if (value > Multiplier.KILO.getMulti()){
            auxValue = value / Multiplier.KILO.getMulti();
            auxAbbreviation = Multiplier.KILO.getPrefix() + getAbbreviation();
        } else {
            auxValue = value;
            auxAbbreviation = getAbbreviation();
        }

        auxValue = Math.round(auxValue * 10000) / 10000d;
        return getIdentifier() + " = " + auxValue + " " + auxAbbreviation;
    }
}
