package cs10.common.model.expression;

import cs10.common.model.MathSign;

public class ProductExpression extends OperationExpression {

    public ProductExpression(MathExpression exp1, MathExpression exp2) {
        super(exp1, exp2, MathSign.MUL);
    }

    @Override
    public double resolve() {
        return getExp1().resolve() * getExp2().resolve();
    }
}
