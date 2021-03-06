package stream;

import dto.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class JoinTest {

    public static void main(String[] args) {
        List<Employee> persons  = Employee.persons();

        // how to use the joining() method
        String names = persons.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());

        String delimitedNames = persons.stream()
               .map(Employee::getName)
               .collect(Collectors.joining(", "));

        String prefixedNames = persons.stream()
               .map(Employee::getName)
               .collect(Collectors.joining(", ", "Hello ",  ".  Goodbye."));

        System.out.println("Joined names:  "  + names);
        System.out.println("Joined,  delimited names:  "  + delimitedNames);
        System.out.println(prefixedNames);
    }

}
