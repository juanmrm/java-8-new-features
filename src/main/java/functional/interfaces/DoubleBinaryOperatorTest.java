package functional.interfaces;

import java.util.function.DoubleBinaryOperator;

class DoubleBinaryOperatorTest {

    public static void main(String[] args) {
        DoubleBinaryOperator d = (l, r) -> l * r;
        System.out.println(d.applyAsDouble(0.23, 0.45));
    }

}
