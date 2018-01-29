package stream;

import dto.Employee;

import java.util.List;

public class ForEachTest {

    public static void main(String[] args) {

        List<Employee> persons = Employee.persons();

        persons.stream()
                .filter(Employee::isFemale)
                .forEach(System.out::println);


        System.out.println("Before increasing the   income:   " + persons);

        persons.stream()
                .filter(Employee::isFemale)
                .forEach(p ->  p.setIncome(p.getIncome() * 1.10));

        System.out.println("After increasing the   income:   " + persons);
    }

}
