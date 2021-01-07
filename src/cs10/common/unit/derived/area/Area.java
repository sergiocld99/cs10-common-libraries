package cs10.common.unit.derived.area;

import cs10.common.unit.Unit;

public abstract class Area extends Unit {

    protected char getExponent(){
        return '2';
    }

    @Override
    public char getIdentifier() {
        return 'A';
    }
}
