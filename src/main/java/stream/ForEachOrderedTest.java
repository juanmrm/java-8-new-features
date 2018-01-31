package stream;

import java.util.Arrays;
import java.util.List;

public class ForEachOrderedTest {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("2","1","3","4");

        stringList.stream()
                .peek(e -> System.out.println(Thread.currentThread().getName()))
                .forEachOrdered(System.out::println);
    }

}
