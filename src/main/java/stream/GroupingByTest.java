package stream;

import dto.Employee;

import java.time.Month;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByTest {

    public static void main(String[] args) {

        // group people by gender
        Map<Employee.Gender, List<Employee>> groupByGender = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender));

        System.out.println(groupByGender);


        //  how to group people by gender and count the number of people in each group.
        Map<Employee.Gender, Long> countByGender = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(countByGender);

        // how to group the names of person by gender
        Map<Employee.Gender, String> namesByGender1 = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.joining(", "))));

        System.out.println(namesByGender1);

        // how to collect the employee names in a List
        Map<Employee.Gender, List<String>> namesByGender2 = Employee.persons()
                        .stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println(namesByGender2);

        // groups people by gender. Within each gender group, it creates another group based on the month of their births and lists the names of the people born in this group.
        Map<Employee.Gender, Map<Month, String>> personsByGenderAndDobMonth = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.groupingBy(p ->  p.getDob().getMonth(), Collectors.mapping(Employee::getName,Collectors.joining(", ")))));

        System.out.println(personsByGenderAndDobMonth);

        // how to summarize Statistics of income grouped by gender
        Map<Employee.Gender, DoubleSummaryStatistics> incomeStatsByGender = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.summarizingDouble(Employee::getIncome)));

        System.out.println(incomeStatsByGender);
    }

}
