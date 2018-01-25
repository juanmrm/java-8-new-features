package functional.interfaces;

import java.util.function.LongBinaryOperator;

class LongBinaryOperatorTest {

    public static void main(String[] args) {
        LongBinaryOperator i = (x, y) -> x / y;
        System.out.println(i.applyAsLong(Long.MAX_VALUE,Long.MAX_VALUE));
    }

}
