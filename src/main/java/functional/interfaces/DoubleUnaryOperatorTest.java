package functional.interfaces;

import java.util.function.DoubleUnaryOperator;

class DoubleUnaryOperatorTest {

    public static void main(String[] args) {
        DoubleUnaryOperator dl = (x) -> x * x;

        System.out.println(dl.andThen(Math::sqrt).applyAsDouble(3.14));
    }

}
