package cs10.common.model.expression;

import cs10.common.model.term.MathTerm;
import cs10.common.model.term.OperationTerm;
import cs10.common.model.term.SingleTerm;
import cs10.common.utils.Math;

import java.util.Arrays;
import java.util.LinkedList;

public class MathExpression extends LinkedList<MathTerm> {

    public MathExpression(){}

    public MathExpression(MathTerm... terms){
        this.addAll(Arrays.asList(terms));
    }

    public MathExpression(String expression){
        addAll(Math.formalizeExpression(expression));
    }

    public ProductExpression associate(String commonOp){
        MathExpression e = findTermsWith(commonOp);
        MathExpression x = new MathExpression();
        MathExpression p = new MathExpression();
        x.add(new SingleTerm(true, commonOp));

        for (MathTerm t : e){
            if (t instanceof OperationTerm)
                p.add(((OperationTerm) t).getTermWithout(commonOp));
            else throw new RuntimeException("Unable to associate " + t);
        }

        return new ProductExpression(p,x);
    }

    public int getAppearancesOf(String op){
        int count = 0;
        for (MathTerm t : this) count += t.getAppearancesOf(op);
        return count;
    }

    public MathTerm getTermWith(String op){
        for (MathTerm t : this) if (t.getAppearancesOf(op) > 0) return t;
        throw new IllegalArgumentException(op + " not found");
    }

    public MathExpression findTermsWith(String op){
        MathExpression result = new MathExpression();
        for (MathTerm t : this) if (t.getAppearancesOf(op) > 0) result.add(t);
        return result;
    }

    public MathExpression findTermsWithout(String op){
        MathExpression result = new MathExpression();
        for (MathTerm t : this) if (t.getAppearancesOf(op) == 0) result.add(t);
        return result;
    }

    public double resolve(){
        double result = 0;

        for (MathTerm t : this){
            if (t.isPositive()) result += t.resolve();
            else result -= t.resolve();
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(get(0).toString());

        for (int i=1; i<size(); i++){
            MathTerm t = get(i);
            sb.append(' ');
            if (t.isPositive()) sb.append("+ ");
            sb.append(t.toString());
        }

        return sb.toString();
    }
}
