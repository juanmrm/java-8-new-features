package functional.interfaces;

import java.util.function.LongConsumer;

class LongConsumerTest {

    public static void main(String[] args) {
        LongConsumer i1 = (l) -> System.out.println("Value is: " + l);
        LongConsumer i2 = (l) -> System.out.println("Half value is: " + l / 2);
        i1.andThen(i2).accept(Long.MAX_VALUE);
    }

}
