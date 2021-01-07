package cs10.common.utils;

import cs10.common.model.MathSign;
import cs10.common.model.expression.MathExpression;
import cs10.common.model.term.*;

import java.util.LinkedList;
import java.util.List;

public class Math {

    public static double interpolate(double knownPrev, double knownTarget, double knownPos,
                               double unknownPrev, double unknownPos){

        double aux = (knownTarget - knownPrev) / (knownPos - knownPrev);
        if (aux < 0 || aux > 1) throw new IllegalArgumentException("Invalid known parameters!");
        return aux * (unknownPos - unknownPrev) + unknownPrev;
    }

    public static double[] interpolate(double[] prev, double[] pos,
                                     double knownTarget, int knownCol){

        double[] result = new double[prev.length];
        double aux = (knownTarget - prev[knownCol]) / (pos[knownCol] - prev[knownCol]);
        if (aux < 0 || aux > 1) throw new IllegalArgumentException("Invalid known parameters!");
        for (int i=0; i<knownCol; i++) result[i] = aux * (pos[i] - prev[i]) + prev[i];
        for (int i=knownCol+1; i<prev.length; i++) result[i] = aux * (pos[i] - prev[i]) + prev[i];
        return result;
    }

    public static int approximate(double value, int multiple){
        // example: value is 140, multiple is 50
        // div is 2.8, round is 3, so this returns 150

        long round = java.lang.Math.round(value / multiple);
        return (int) round * multiple;
    }

    public static MathExpression formalizeExpression(String expression){
        MathExpression result = new MathExpression();
        for (String t : splitTerms(expression)){
            if (t.contains("(")) result.addAll(distribute(t));
            else result.add(formalizeTerm(t));
        }

        return result;
    }

    public static MathTerm formalizeTerm(String term){
        boolean positive = !term.startsWith("-");

        String exp = term.replace("+","")
                .replace("-","").trim();
        String[] params = exp.split(" ");

        if (params.length == 1) return new SingleTerm(positive, exp);
        else {
            if (params.length == 2)
                return new ProductTerm(positive, params[0], params[1]);
            else if (params[1].equals("*"))
                return new ProductTerm(positive, params[0], params[2]);
            else if (params[1].equals("/"))
                return new FractionTerm(positive, params[0], params[2]);
        }

        throw new RuntimeException("Unknown term type: " + exp);
    }

    public static List<String> splitTerms(String expression){
        boolean isParenthesisOpen = false;
        List<String> result = new LinkedList<>();
        StringBuilder actual = new StringBuilder();

        for (char c : expression.toCharArray()){
            if (c == '('){
                if (isParenthesisOpen) throw new IllegalArgumentException("(( not allowed");
                isParenthesisOpen = true;
            } else if (c == ')') {
                if (!isParenthesisOpen) throw new IllegalArgumentException(") before (");
                isParenthesisOpen = false;
            }

            if (c == MathSign.PLUS.getSymbol() || c == MathSign.MINUS.getSymbol()) {
                if (!isParenthesisOpen) {
                    result.add(actual.toString().trim());
                    actual = new StringBuilder();
                }
            }

            actual.append(c);
        }

        if (actual.length() > 0) result.add(actual.toString().trim());
        return result;
    }

    public static MathExpression distribute(String term){
        StringBuilder parenthesis = new StringBuilder();
        StringBuilder single = new StringBuilder();
        boolean isParenthesisOpen = false;

        for (char c : term.toCharArray()){
            if (c == '(') isParenthesisOpen = true;
            else if (c == ')') isParenthesisOpen = false;
            else if (isParenthesisOpen) parenthesis.append(c);
            else if (c != MathSign.MUL.getSymbol()) single.append(c);
        }

        MathExpression p = formalizeExpression(parenthesis.toString().trim());
        SingleTerm t = new SingleTerm(true, single.toString().trim());
        return Math.distribute(p,t);
    }

    public static MathExpression distribute(MathExpression parenthesis, SingleTerm commonTerm){
        MathExpression result = new MathExpression();

        for (MathTerm t : parenthesis){
            if (t instanceof SingleTerm){
                ProductTerm p = new ProductTerm((SingleTerm) t, commonTerm);
                result.add(p);
            } else throw new RuntimeException("Unable to distribute " + t);
        }

        return result;
    }
}
