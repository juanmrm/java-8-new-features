package functional.interfaces;

import java.util.function.LongPredicate;

class LongPredicateTest {

    public static void main(String[] args) {
        LongPredicate p1 = (l) -> l > 0;
        LongPredicate p2 = (l) -> 2 * l < 10;

        System.out.println(p1.and(p2).test(4L));
        System.out.println(p1.and(p2).test(6L));
        System.out.println(p1.or(p2).test(4L));

    }

}
