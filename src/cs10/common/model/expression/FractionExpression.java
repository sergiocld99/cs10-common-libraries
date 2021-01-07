package cs10.common.model.expression;

import cs10.common.model.MathSign;

public class FractionExpression extends OperationExpression {

    public FractionExpression(MathExpression numerator, MathExpression denominator){
        super(numerator, denominator, MathSign.DIVIDE);
    }

    @Override
    public double resolve() {
        return getExp1().resolve() / getExp2().resolve();
    }
}
