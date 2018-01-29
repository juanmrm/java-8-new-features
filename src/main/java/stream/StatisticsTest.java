package stream;

import dto.Employee;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class StatisticsTest {

    public static void main(String[] args) {

        // compute the statistics on a number of double values
        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
        stats.accept(100.0);
        stats.accept(300.0);
        stats.accept(230.0);
        stats.accept(532.0);
        stats.accept(422.0);

        long count = stats.getCount();
        double sum = stats.getSum();
        double min = stats.getMin();
        double avg = stats.getAverage();
        double max = stats.getMax();

        System.out.printf("count=%d, sum=%.2f,  min=%.2f,  average=%.2f, max=%.2f%n", count, sum, min, max, avg);

        // how to compute the summary statistics for incomes
        DoubleSummaryStatistics incomeStats1 = Employee.persons()
                .stream()
                .map(Employee::getIncome)
                .collect(DoubleSummaryStatistics::new,
                        DoubleSummaryStatistics::accept,
                        DoubleSummaryStatistics::combine);
        System.out.println(incomeStats1);

        // another way for the same result
        DoubleSummaryStatistics incomeStats2 = Employee.persons()
                .stream()
                .collect(Collectors.summarizingDouble(Employee::getIncome));
        System.out.println(incomeStats2);
    }

}
