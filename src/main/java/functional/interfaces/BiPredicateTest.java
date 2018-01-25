package functional.interfaces;

import java.util.function.BiPredicate;

class BiPredicateTest {

    public static void main(String[] args) {
        BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
        System.out.println(bi.and((z, t) -> z < 10 && t < 10).test(6, 2));

        // how to use BiPredicate as function parameter.
        boolean result = compare((a, b) -> a / 2 == b, 10, 5);
        System.out.println("Compare result: " + result);

    }

    static boolean compare(BiPredicate<Integer, Integer> bi, Integer i1, Integer i2) {
        return bi.test(i1, i2);
    }

}
