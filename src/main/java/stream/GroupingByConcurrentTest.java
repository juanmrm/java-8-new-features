package stream;

import dto.Employee;

import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByConcurrentTest {

    public static void main(String[] args) {
        Map<Employee.Gender, String> namesByGender = Employee.persons()
                .stream()
                .collect(Collectors.groupingByConcurrent(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.joining(", "))));
        System.out.println(namesByGender);
    }

}
