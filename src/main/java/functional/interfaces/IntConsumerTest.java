package functional.interfaces;

import java.util.function.IntConsumer;

class IntConsumerTest {

    public static void main(String[] args) {
        IntConsumer ic1 = (x) -> System.out.println(Math.pow(x, 2));
        IntConsumer ic2 = (x) -> System.out.println(Math.pow(x, 3));
        IntConsumer ic3 = (x) -> System.out.println(Math.pow(x, 4));

        ic1.andThen(ic2).andThen(ic3).accept(3);
    }

}
