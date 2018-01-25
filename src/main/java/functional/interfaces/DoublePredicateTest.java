package functional.interfaces;

import java.util.function.DoublePredicate;

class DoublePredicateTest {

    public static void main(String[] args) {
        DoublePredicate dp = (d) -> d > 10;

        System.out.println(dp.negate().test(0.5));
        System.out.println(dp.negate().test(15));
    }

}
