package stream;

import dto.Employee;

import java.util.stream.IntStream;

public class MapTest {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .forEach(System.out::println);

        Employee.persons()
                .stream()
                .map(Employee::getName)
                .forEach(System.out::println);

    }

}
