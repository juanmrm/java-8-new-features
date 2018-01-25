package functional.interfaces;

import java.util.function.IntPredicate;

class IntPredicateTest {

    public static void main(String[] args) {
        IntPredicate i = (x) -> x < 0;

        System.out.println(i.negate().test(123));

    }

}
