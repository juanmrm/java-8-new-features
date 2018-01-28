package stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamFromFunctionTest {

    public static void main(String[] args) {
        // Generate first 10 natural numbers
        Stream<Long> tenNaturalNumbers = Stream.iterate(1L, n  ->  n  + 1)
                .limit(10);
        tenNaturalNumbers.forEach(System.out::println);

        // First 5 odd numbers starting fron 2.
        Stream.iterate(2L, n  ->  n  + 1)
                .filter(StreamFromFunctionTest::isOdd)
                .limit(5)
                .forEach(System.out::println);

        // Skip the first 100 generated values
        Stream.iterate(2L, n  ->  n  + 1)
                .filter(StreamFromFunctionTest::isOdd)
                .skip(100)
                .limit(5)
                .forEach(System.out::println);

        // Generate five random numbers
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // Generate a unordered stream in which the next element is generated based on the previous one
        Stream.generate(StreamFromFunctionTest::next)
                .limit(5)
                .forEach(System.out::println);

        // Prints five random int values from an IntStream returned from the ints()
        new Random().ints()
                .limit(5)
                .forEach(System.out::println);

        // Prints five random int values
        Stream.generate(new Random()::nextInt)
                .limit(5)
                .forEach(System.out::println);

        // Work only with primitive type values
        IntStream.generate(new Random()::nextInt)
                .limit(5)
                .forEach(System.out::println);

        // Generate infinite stream of repeating values
        IntStream.generate(() ->  0)
                .limit(5)
                .forEach(System.out::println);

    }

    static boolean isOdd(long number) {
        if (number % 2 == 0) {
            return false;
        }
        return true;
    }

    static int v=0;
    private static int next(){
        v++;
        return v;
    }


}
