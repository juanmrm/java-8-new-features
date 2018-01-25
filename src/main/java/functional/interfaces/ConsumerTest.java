package functional.interfaces;

import java.util.function.Consumer;

class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> firstWord = (x) -> System.out.println(x.trim().split("\\s+")[0].toLowerCase());
        Consumer<String> secondWord = (x) -> System.out.println(x.trim().split("\\s+")[1].toLowerCase());

        firstWord.andThen(secondWord).accept("CONSUMER TEST");
    }

}
