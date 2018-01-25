package functional.interfaces;

import java.util.function.IntBinaryOperator;

class IntBinaryOperatorTest {

    public static void main(String[] args) {
        IntBinaryOperator io = (x, y) -> x + y;

        System.out.println(io.applyAsInt(2,3));

    }

}
