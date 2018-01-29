package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArryOrCollectionTest {

    public static void main(String[] args) {

        // From Arrays
        IntStream numbers = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        numbers.forEach(System.out::println);
        Stream<String> names1 = Arrays.stream(new String[] {"XML",   "Java"});
        names1.forEach(System.out::println);

        // From Collection
        List<String> names2 = Stream.iterate(1L, n -> n + 1)
                .limit(25)
                .map(e -> "Str num " + e)
                .collect(Collectors.toList());

        System.out.println("Process in sequential mode");
        System.out.println("**************************");
        Stream<String> sequentialStream  = names2.stream();
        sequentialStream.forEach(System.out::println);

        System.out.println("Process in parallel mode");
        System.out.println("**************************");
        Stream<String> parallelStream = names2.parallelStream();
        parallelStream.forEach(System.out::println);

    }

}
