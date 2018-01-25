package functional.interfaces;

import java.util.function.IntUnaryOperator;

class IntUnaryOperatorTest {

    public static void main(String[] args) {
        IntUnaryOperator i = (x) -> x * x;
        System.out.println(i.compose(i).applyAsInt(2));
    }

}
