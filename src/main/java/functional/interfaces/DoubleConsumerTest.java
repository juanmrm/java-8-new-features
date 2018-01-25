package functional.interfaces;

import java.util.function.DoubleConsumer;

class DoubleConsumerTest {

    public static void main(String[] args) {
        DoubleConsumer square = (x) -> System.out.println("x ^ 2: " + Math.pow(x, 2));
        DoubleConsumer cubic = (x) -> System.out.println("x ^ 3: " + Math.pow(x, 3));

        square.andThen(cubic).accept(0.23);
    }

}
