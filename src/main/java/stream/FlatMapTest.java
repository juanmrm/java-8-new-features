package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapTest {

    public static void main(String[] args) {

        // maps a stream of three numbers: 1, 2, and 3 to produce a stream that contains the numbers and their next numbers
        Stream.of(1, 2, 3)
                .flatMap(n -> Stream.of(n, n+1))
                .forEach(System.out::println);

        // how to convert a stream of strings to a stream of characters
        Stream.of("XML", "Java",  "CSS")
                .map(name -> name.chars())
                .flatMap(is -> is.mapToObj(n ->  (char)n))
                .forEach(System.out::println);

        Stream.of("XML", "Java",  "CSS")
                .flatMap(name -> IntStream
                        .range(0, name.length())
                        .mapToObj(name::charAt))
                .forEach(System.out::println);

    }

}
