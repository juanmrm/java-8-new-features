package functional.interfaces;

import java.util.function.BiConsumer;

class BiConsumerTest {

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (x, y) -> {
            System.out.println("First value: " + x);
            System.out.println("Second value: " + y);
        };

        biConsumer.andThen((a, b) -> System.out.println("Concat values: " + a.concat(" ").concat(b))).accept("biconsumer", "test");
    }

}
