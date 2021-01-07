package cs10.common.model.equation;

import cs10.common.model.expression.FractionExpression;
import cs10.common.model.expression.MathExpression;
import cs10.common.model.expression.OperationExpression;
import cs10.common.model.expression.ProductExpression;
import cs10.common.model.term.MathTerm;
import cs10.common.model.term.OperationTerm;
import cs10.common.model.term.ProductTerm;
import cs10.common.model.term.SingleTerm;

public class MathEquation {
    private final static boolean DEBUG = false;
    private final MathExpression left, right;
    private final String incognita;

    public MathEquation(MathExpression left, MathExpression right, String incognita) {
        this.left = left;
        this.right = right;
        this.incognita = incognita;
    }

    public MathEquation(String expression, String incognita){
        String[] expressions = expression.split(" = ");
        this.left = new MathExpression(expressions[0]);
        this.right = new MathExpression(expressions[1]);
        this.incognita = incognita;
        if (DEBUG) System.out.println(this);
    }

    public OperationExpression clear(){
        int l = left.getAppearancesOf(incognita);
        int r = right.getAppearancesOf(incognita);

        if (l > 0 & r > 0) {
            mainClear(left, right);
            moveIncognita();
            return associateAndReturn();
        }

        if (l > 0) return clear(left, right, l);
        else if (r > 0) return clear(right, left, r);
        else throw new RuntimeException("Incognita not found");
    }

    private void moveIncognita(){
        for (MathTerm t : right.findTermsWith(getIncognita())){
            t.invertSign();
            left.add(t);
            right.remove(t);
        }
    }

    private FractionExpression associateAndReturn(){
        ProductExpression p = left.associate(getIncognita());
        if (DEBUG) System.out.println(p + " = " + right);
        return new FractionExpression(right, p.getExp1());
    }

    private OperationExpression clear(MathExpression incognitaSide, MathExpression otherSide, int count){
        mainClear(incognitaSide, otherSide);

        if (count == 1){
            MathTerm x = incognitaSide.getTermWith(getIncognita());
            if (x instanceof SingleTerm){
                MathExpression neutral = new MathExpression("1");
                return new ProductExpression(neutral, otherSide);
            }

            if (x instanceof OperationTerm){
                if (x instanceof ProductTerm){
                    MathTerm dTerm = ((ProductTerm) x).getTermWithout(getIncognita());
                    MathExpression d = new MathExpression(dTerm);
                    return new FractionExpression(otherSide, d);
                }
            }
        } else return associateAndReturn();

        throw new RuntimeException("Unable to resolve " + this);
    }

    private void mainClear(MathExpression incognitaSide, MathExpression otherSide){
        MathExpression termsWithoutIncognita = incognitaSide.findTermsWithout(incognita);

        for (MathTerm t : termsWithoutIncognita){
            t.invertSign();
            otherSide.add(t);
            incognitaSide.remove(t);
            if (DEBUG) System.out.println(this);
        }
    }

    public String getIncognita() {
        return incognita;
    }

    @Override
    public String toString() {
        return left + " = " + right;
    }
}
