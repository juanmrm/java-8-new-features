package stream;

import dto.Employee;

import java.util.Arrays;
import java.util.List;

public class ToArrayTest {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("2","1","3","4");

        Object[] n = stringList.stream()
                .toArray();

        System.out.println(Arrays.toString(n));


        List<Employee> persons = Employee.persons();

        Employee[] men = persons.stream()
                .filter(Employee::isMale)
                .peek(System.out::println)
                .map(e -> {
                    e.setIncome(2 * e.getIncome());
                    return e;
                })
                .toArray(Employee[]::new);

        System.out.println("After increasing the income: ");
        Arrays.stream(men).forEach(System.out::println);
    }

}
