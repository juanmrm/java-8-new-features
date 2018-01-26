package optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class optionalTest {

    public static void main(String[] args) {
        Optional<String> empty  = Optional.empty();
        System.out.println(empty);

        Optional<String> str1 = Optional.of("cadena");
        System.out.println(str1);

        String nullableString = "";
        Optional<String> str2  = Optional.of(nullableString);
        System.out.println(str2);

        // Prints the value in an Optional if it contains a non-null value
        Optional<String> str3 = Optional.of("cadena");

        if (str3.isPresent()) {
            String value = str3.get();
            System.out.println("Optional contains " + value);
        } else {
            System.out.println("Optional is  empty.");
        }

        // ifPresent(Consumer<? super T> action) method from the Optional class takes an action on the value contained in the Optional.
        str1.ifPresent(value -> System.out.println("Consuming Optional containing: " + value));


        OptionalInt number = OptionalInt.of(2);

        if (number.isPresent()) {
            int value = number.getAsInt();
            System.out.println("Number is " + value);
        } else {
            System.out.println("Number is absent.");
        }

        // Stream Optional Value
        OptionalInt maxOdd = IntStream.of(10, 20, 30).filter(n -> n % 2 == 1).max();
        if (maxOdd.isPresent()) {
            int value = maxOdd.getAsInt();
            System.out.println("Maximum odd  integer is " + value);
        } else {
            System.out.println("Stream is  empty.");
        }
    }


}
