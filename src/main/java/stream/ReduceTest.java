package stream;

import dto.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceTest {

    public static void main(String[] args) {

        // T  reduce(T identity, BinaryOperator<T> accumulator)

        // sum of the numbers in a List
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum1 = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum1);

        // sum of the incomes of all employee.
        double sum2 = Employee.persons()
                .stream()
                .map(Employee::getIncome)
                .reduce(0.0, Double::sum);
        System.out.println(sum2);

        /*
            <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
            The second version of the reduce method allows us to perform a map operation, followed by a reduce operation.
            The third argument is used for combining the partial results when the reduce operation is performed in parallel.
         */
        double sum3 = Employee
                .persons()
                .stream()
                .reduce(
                        0.0,
                        (Double partialSum, Employee p) -> {
                            double accumulated = partialSum + p.getIncome();
                            System.out.println(Thread.currentThread().getName()
                                    + "  - Accumulator: partialSum  = " + partialSum
                                    + ",  person = " + p + ", accumulated = " + accumulated);
                            return accumulated;
                        },
                        (a, b) -> {
                            double combined = a + b;
                            System.out.println(Thread.currentThread().getName()
                                    + "  - Combiner:  a  = " + a + ", b  = " + b
                                    + ", combined  = " + combined);
                            return combined;
                        });
        System.out.println("--------------------------------------");
        System.out.println(sum3);

        sum3 = Employee
                .persons()
                .parallelStream()
                .reduce(
                        0.0,
                        (Double partialSum, Employee p) -> {
                            double accumulated = partialSum + p.getIncome();
                            System.out.println(Thread.currentThread().getName()
                                    + "  - Accumulator: partialSum  = " + partialSum
                                    + ",  person = " + p + ", accumulated = " + accumulated);
                            return accumulated;
                        },
                        (a, b) -> {
                            double combined = a + b;
                            System.out.println(Thread.currentThread().getName()
                                    + "  - Combiner:  a  = " + a + ", b  = " + b
                                    + ", combined  = " + combined);
                            return combined;
                        });
        System.out.println(sum3);


        // Third version is reduce(BinaryOperator<T> accumulator)
        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5).reduce(Integer::max);

        if (max.isPresent()) {
            System.out.println("max = " + max.get());
        } else {
            System.out.println("max is not  defined.");
        }

        max = Stream.<Integer> empty().reduce(Integer::max);
        if (max.isPresent()) {
            System.out.println("max = " + max.get());
        } else {
            System.out.println("max is not  defined.");
        }

        // Prints the details of the highest earner in the employee's list.
        Optional<Employee> person = Employee
                .persons()
                .stream()
                .reduce((p1, p2) -> p1.getIncome() > p2.getIncome() ? p1 : p2);
        if (person.isPresent()) {
            System.out.println("Highest earner: " + person.get());
        } else {
            System.out.println("Could not  get   the   highest earner.");
        }
    }

}
