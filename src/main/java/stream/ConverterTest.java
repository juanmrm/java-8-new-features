package stream;

import dto.Employee;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterTest {

    public static void main(String[] args) {

        // convert the result of the collector to a different type
        List<String> names = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(), result ->  Collections.unmodifiableList(result)));
        System.out.println(names);
    }

}
