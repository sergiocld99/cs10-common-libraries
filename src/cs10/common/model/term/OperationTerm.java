package cs10.common.model.term;

import cs10.common.model.MathSign;

public abstract class OperationTerm extends MathTerm {
    private SingleTerm value1, value2;
    private MathSign operation;

    public OperationTerm(){}

    public OperationTerm(SingleTerm value1, SingleTerm value2, MathSign operation) {
        super(value1.isPositive());
        this.value1 = value1;
        this.value2 = value2;
        this.operation = operation;
    }

    public SingleTerm getTermWithout(String op){
        SingleTerm result;

        if (value1.getValue().equals(op)) result = new SingleTerm(value2);
        else if (value2.getValue().equals(op)) result = new SingleTerm(value1);
        else throw new IllegalArgumentException(op + " not found");

        result.setPositive(isPositive());
        return result;
    }

    @Override
    public int getAppearancesOf(String op) {
        return value1.getAppearancesOf(op) + value2.getAppearancesOf(op);
    }

    public MathTerm getValue1() {
        return value1;
    }

    public MathTerm getValue2() {
        return value2;
    }

    public MathSign getOperation() {
        return operation;
    }

    @Override
    public void invertSign() {
        if (!isPositive()) getValue1().setPositive(true);
        super.invertSign();
    }

    @Override
    public String toString() {
        return (isPositive() == getValue1().isPositive() ? "" : "- ") + getValue1() + " " +
                getOperation().getSymbol() + " " + getValue2();
    }
}
