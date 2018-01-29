package stream;

import dto.Employee;

public class FilterTest {

    public static void main(String[] args) {

        System.out.println("Female persons: ");
        Employee.persons()
                .stream()
                .filter(Employee::isFemale)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("Male persons with more than 5000 of incomes: ");
        Employee.persons()
                .stream()
                .filter(p ->  p.isMale() &&  p.getIncome() > 5000.0)
                .map(Employee::getName)
                .forEach(System.out::println);
    }


}
