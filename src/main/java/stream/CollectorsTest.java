package stream;

import dto.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsTest {

    public static void main(String[] args) {

        // First way
        List<String> names1 = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(ArrayList::new,  ArrayList::add, ArrayList::addAll);
        System.out.println(names1);

        // Second way
        List<String> names2 = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(names2);

        // collects all names in a Set<String> which keeps only unique elements
        Set<String> uniqueNames  = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        System.out.println(uniqueNames);

        // collect names in a sorted set using the toCollection() method as follows:
        SortedSet<String> uniqueSortedNames = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(uniqueSortedNames);
    }

}
