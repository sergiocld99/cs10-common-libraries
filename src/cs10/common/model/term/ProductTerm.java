package cs10.common.model.term;

import cs10.common.model.MathSign;

public class ProductTerm extends OperationTerm {

    public ProductTerm(SingleTerm value1, SingleTerm value2) {
        super(value1, value2, MathSign.MUL);
    }

    public ProductTerm(boolean positive, String op1, String op2){
        this(new SingleTerm(positive, op1), new SingleTerm(true, op2));
    }

    @Override
    public double resolve() {
        return getValue1().resolve() * getValue2().resolve();
    }
}
