package cs10.common.model.term;

public class SingleTerm extends MathTerm {
    private final String value;

    public SingleTerm(boolean positive, String value) {
        super(positive);
        this.value = value;
    }

    public SingleTerm(SingleTerm term){
        this(term.isPositive(), term.getValue());
    }

    public String getValue() {
        return value;
    }

    @Override
    public double resolve() {
        return Double.parseDouble(value);
    }

    @Override
    public int getAppearancesOf(String op) {
        return (value.equals(op) ? 1 : 0);
    }

    @Override
    public String toString() {
        return (isPositive() ? "" : "- ") + value;
    }
}
