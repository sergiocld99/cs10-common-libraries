package cs10.common.model.expression;

import cs10.common.model.MathSign;

public abstract class OperationExpression {
    private final MathExpression exp1, exp2;
    private final MathSign sign;

    public OperationExpression(MathExpression exp1, MathExpression exp2, MathSign sign) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.sign = sign;
    }

    public MathExpression getExp1() {
        return exp1;
    }

    public MathExpression getExp2() {
        return exp2;
    }

    public MathSign getSign() {
        return sign;
    }

    public abstract double resolve();

    @Override
    public String toString() {
        return "( " + exp1 + " ) " + getSign().getSymbol() + " ( " + exp2 + " )";
    }
}
