package functional.interfaces;

import java.util.function.BinaryOperator;

class BinaryOperatorTest {

    public static void main(String[] args) {

        System.out.println("Binary Operator using minBy: " + BinaryOperator
                .minBy(Integer::compareTo)
                .andThen(x -> x * 5)
                .apply(3, 4));

        System.out.println("Binary Operator using maxBy: " + BinaryOperator
                .maxBy(Integer::compareTo)
                .andThen(x -> x * 5)
                .apply(3, 4));
    }

}
