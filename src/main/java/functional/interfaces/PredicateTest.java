package functional.interfaces;

import dto.Box;
import dto.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> i  = (s) -> s.length() > 5;

        System.out.println(i.test("Cadena"));
        System.out.println(Predicate.isEqual("Cadena").test("Cadena"));

        // how to create Predicate from method reference and lambda
        List<Box> inventory = Arrays.asList(
                new Box(80, "green"),
                new Box(155, "green"),
                new Box(120, "red"));

        List<Box> greenApples = filter(inventory, PredicateTest::isGreenApple);
        System.out.println(greenApples);

        List<Box> heavyApples = filter(inventory, PredicateTest::isHeavyApple);
        System.out.println(heavyApples);

        List<Box> greenApples2 = filter(inventory,(Box a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        List<Box> heavyApples2 = filter(inventory,(Box a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        List<Box> weirdApples = filter(inventory,(Box a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        System.out.println(weirdApples);

        // how to return Predicate
        List<Student> employees = Arrays.asList(
                new Student(1, 3_000, "John"),
                new Student(2, 30_000, "Jane"),
                new Student(3, 40_000, "Jack")
        );

        // with predicate
        System.out.println(findStudents(employees, createCustomPredicateWith(10_000)));

        // with function definition, both are same
        Function<Double, Predicate<Student>> customFunction = threshold -> (e -> e.getGpa() > threshold);
        System.out.println(findStudents(employees, customFunction.apply(10_000D)));

    }

    static boolean isGreenApple(Box apple) {
        return "green".equals(apple.getColor());
    }

    static boolean isHeavyApple(Box apple) {
        return apple.getWeight() > 150;
    }

    static List<Box> filter(List<Box> inventory, Predicate<Box> p) {
        return inventory.stream()
                .filter(p)
                .collect(Collectors.toList());
    }

    static Predicate<Student> createCustomPredicateWith(double threshold) {
        return e -> e.getGpa() > threshold;
    }

    static List<Student> findStudents(List<Student> employees, Predicate<Student> condition) {
        return employees.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

}


