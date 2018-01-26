package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        //  creates a stream with four strings
        Stream<String> stream1  = Stream.of("XML", "Java",  "CSS", "SQL");
        stream1.forEach(System.out::println);

        // creates a stream from an array of objects
        String[] names = { "XML", "Java", "SQL", "CSS" };
        Stream<String> stream2 = Stream.of(names);
        stream2.forEach(System.out::println);

        // use Stream.Builder<T> to create streams.
        Stream<String> stream3  = Stream.<String>builder()
                .add("XML")
                .add("Java")
                .add("CSS")
                .add("SQL")
                .build();
        stream3.forEach(System.out::println);

        // IntStream from range
        IntStream oneToFive  = IntStream.range(1, 6);
        //IntStream oneToFive  = IntStream.rangeClosed(1, 5);
        oneToFive.forEach(System.out::println);
    }

}
