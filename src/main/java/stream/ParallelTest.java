package stream;

import dto.Employee;

import java.util.stream.Collectors;

public class ParallelTest {

    public static void main(String[] args) {

        // how to do serial processing of the stream
        System.out.println("************** SERIAL PROCESSING ************");
        String names1 = Employee.persons()
                .stream()
                .peek(e -> System.out.println(Thread.currentThread().getName()))
                .filter(Employee::isMale)
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(names1 + "\n");

        System.out.println("************** PARALLEL PROCESSING ************");
        names1 = Employee.persons()
                .parallelStream()
                .peek(e -> System.out.println(Thread.currentThread().getName()))
                .filter(Employee::isMale)
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(names1 + "\n");

        // how to mix serial and parallel streams
        System.out.println("************** SERIAL AND PARALLEL PROCESSING ************");
        String names2 = Employee.persons()                // The data source
                .stream()                  // Produces a  sequential  stream
                .peek(e -> System.out.println(Thread.currentThread().getName()))
                .filter(Employee::isMale)   // Processed in serial
                .parallel()               // Produces a  parallel  stream
                .peek(e -> System.out.println(Thread.currentThread().getName()))
                .map(Employee::getName)       // Processed in parallel
                .collect(Collectors.joining(", "));  // Processed in parallel
        System.out.println(names2 + "\n");

    }

}
