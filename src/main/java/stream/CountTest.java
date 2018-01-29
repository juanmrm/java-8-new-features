package stream;

import dto.Employee;

public class CountTest {

    public static void main(String[] args) {
        long personCount1 = Employee.persons()
                .stream()
                .count();
        System.out.println("Person count: " + personCount1);

        // uses the map() method to count the number of elements in a stream.
        long personCount2 = Employee.persons()
                .stream()
                .mapToLong(p ->  1L)
                .sum();
        System.out.println("Person count: " + personCount2);

        //  uses the map() and reduce() methods to implement the count operation.
        long personCount3 = Employee.persons()
                .stream()
                .map(p  ->  1L)
                .reduce(0L,  Long::sum);
        System.out.println("Person count: " + personCount3);

        // uses the reduce() method to implement the count operation
        long personCount4 = Employee.persons()
                .stream()
                .reduce(0L, (partialCount,  person) ->  partialCount + 1L,  Long::sum);
        System.out.println("Person count: " + personCount4);
    }

}
