package stream;

import dto.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningTest {

    public static void main(String[] args) {

        // how to partition employee by gender
        Map<Boolean, List<Employee>> partionedByMaleGender1 = Employee.persons()
                        .stream()
                        .collect(Collectors.partitioningBy(Employee::isMale));
        System.out.println(partionedByMaleGender1);

        // how to partition employee by gender, and collects their names in a comma-separated string
        Map<Boolean,String> partionedByMaleGender2 = Employee.persons()
                .stream()
                .collect(Collectors.partitioningBy(Employee::isMale, Collectors.mapping(Employee::getName, Collectors.joining(", "))));
        System.out.println(partionedByMaleGender2);
    }

}
