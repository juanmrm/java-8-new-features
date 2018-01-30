package stream;

import dto.Employee;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMapTest {

    public static void main(String[] args) {

        // collects a employee's data in a Map<long,String> whose keys are the employee's ids and values are employee's names.
        Map<Long,String> idToNameMap  = Employee.persons()
                .stream()
                .collect(Collectors.toMap(Employee::getId,  Employee::getName));
        System.out.println(idToNameMap);

        // how to concatenate the names of all males and females
        Map<Employee.Gender, String> genderToNamesMap = Employee.persons()
                .stream()
                .collect(Collectors.toMap(Employee::getGender, Employee::getName, (oldValue, newValue) -> String.join(", ", oldValue,  newValue)));
        System.out.println(genderToNamesMap);


        // summarizes the number of people by gender
        Map<Employee.Gender, Long> countByGender = Employee.persons()
                .stream()
                .collect(Collectors.toMap(Employee::getGender, p -> 1L, (oldCount, newCount) -> newCount + oldCount));
        System.out.println(countByGender);

        // get the highest earner by gender in a Map
        Map<Employee.Gender, Employee> highestEarnerByGender = Employee.persons()
                .stream()
                .collect(Collectors.toMap(Employee::getGender, Function.identity(), (oldPerson, newPerson)  -> newPerson.getIncome() > oldPerson.getIncome() ? newPerson : oldPerson));
        System.out.println(highestEarnerByGender);
    }

}
