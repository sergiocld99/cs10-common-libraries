package cs10.common.unit;

public enum Multiplier {
    DECA('D',1), HECTO('h',2),
    KILO('k',3), MEGA('M',6),
    DECI('d',-1), CENTI('c',-2),
    MILLI('m',-3), MICRO('u',-6);

    private final char prefix;
    private final int exponent;

    Multiplier(char prefix, int exponent){
        this.prefix = prefix;
        this.exponent = exponent;
    }

    public char getPrefix() {
        return prefix;
    }

    public int getExponent() {
        return exponent;
    }

    public double getMulti(){
        return Math.pow(10, exponent);
    }
}
