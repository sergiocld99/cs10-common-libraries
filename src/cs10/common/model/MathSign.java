package cs10.common.model;

public enum MathSign {
    PLUS('+',true), MINUS('-',false),
    MUL('*',true), DIVIDE('/',true);

    private final char symbol;
    private final boolean positive;

    MathSign(char symbol, boolean positive) {
        this.symbol = symbol;
        this.positive = positive;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isPositive() {
        return positive;
    }
}
