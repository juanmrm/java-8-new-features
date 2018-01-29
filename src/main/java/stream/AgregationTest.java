package stream;

import dto.Employee;

import java.util.*;
import java.util.stream.IntStream;

public class AgregationTest {

    public static void main(String[] args) {

        List<Employee> employees = Employee.persons();

        // calculates the sum of the incomes.
        double totalIncome = employees
                .stream()
                .mapToDouble(Employee::getIncome)
                .sum();
        System.out.println("Total Income:  "  + totalIncome);

        // Get employee with maximum income.
        Optional<Employee> person = employees
                .stream()
                .max(Comparator.comparingDouble(Employee::getIncome));

        if (person.isPresent()) {
            System.out.println("Highest earner: " + person.get());
        } else {
            System.out.println("Could not  get   the   highest earner.");
        }

        // prints the highest income in the employee list using the max() method of the DoubleStream
        OptionalDouble income = employees
                        .stream()
                        .mapToDouble(Employee::getIncome)
                        .max();

        if (income.isPresent()) {
            System.out.println("Highest income:   " + income.getAsDouble());
        } else {
            System.out.println("Could not  get   the   highest income.");
        }

        // Get the index for the employee with the max income
        IntStream.range(0, employees.size())
                .peek(i -> System.out.println("Index "+ i + " Value: " + employees.get(i).getIncome()))
                .reduce((i, j) -> Comparator.comparingDouble(Employee::getIncome).compare(employees.get(i), employees.get(j)) > 0 ? i : j)
                .ifPresent(ix -> System.out.println("Index " + ix + ", value " + employees.get(ix)));

    }

}
