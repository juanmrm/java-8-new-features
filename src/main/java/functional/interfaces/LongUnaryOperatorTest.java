package functional.interfaces;

import java.util.function.LongUnaryOperator;

class LongUnaryOperatorTest {

    public static void main(String[] args) {
        LongUnaryOperator i1 = (l) -> -l;
        LongUnaryOperator i2 = (l) -> l / 2;

        System.out.println(i1.andThen(i2).applyAsLong(Long.MAX_VALUE));
    }


}
