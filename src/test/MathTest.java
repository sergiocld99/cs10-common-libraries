package test;

import cs10.common.model.equation.MathEquation;
import cs10.common.model.expression.OperationExpression;

public class MathTest {

    public static void main(String[] args) {
        simpleTests();
        advancedTest();
    }

    public static void simpleTests(){
        test("2 x + 5 = 9", "x", true);
        test("3 x + 7 = 2 x - 4", "x", true);
        test("5 x - 9 = 3 x + 6", "x", true);
        test("2 x - 5 = 3 x + 4", "x", true);
        test("5 x - 1 = 7 x - 4", "x", true);
    }

    public static void test(String expression, String incognita, boolean resolve){
        System.out.println(expression);

        MathEquation equation = new MathEquation(expression, incognita);
        OperationExpression cleared = equation.clear();
        System.out.println(incognita + " = " + cleared);

        if (resolve) System.out.println(incognita + " = " + cleared.resolve());
    }

    public static void advancedTest(){
        String example = "( 1 - a1 + a2 ) * h1 + a1 * h2 = 1 * h3";
        long startTime = System.currentTimeMillis();
        test(example, "a1", false);
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
