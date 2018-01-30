package stream;

import dto.Employee;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class ConverterTest {

    public static void main(String[] args) {

        // convert the result of the collector to a different type
        List<String> names = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(), result ->  Collections.unmodifiableList(result)));
        System.out.println(names);

        Map<Month, String> dobCalendar = Employee.persons()
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(p -> p.getDob().getMonth(), Collectors.mapping(Employee::getName, Collectors.joining(" "))),
                        result -> {
                            for (Month m : Month.values()) {
                                result.putIfAbsent(m, "None");
                            }
                            return new TreeMap<>(result);
                        }
                ));

        dobCalendar.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Month::getValue)))
                .forEach(System.out::println);
    }

}
