package functional.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

class BiFunctionTest {

    public static void main(String[] args) {
        BiFunction<String, String, String> bi = (x, y) -> x.concat(" ").concat(y);
        System.out.println(bi.andThen(z -> "Resultado Concatenado: ".concat(z)).apply("bifunction", " test"));

        // how to use BiFunction as a parameter
        Calculator calculator = new Calculator();
        String result = calculator.calc((a, b) -> "Use BiFunction as a parameter: " + (a * b),3,  5);
        System.out.println(result);

        // how to map by Function.
        List<Integer> _numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Function<Integer, Integer> lambda = value -> value * 2;

        List<Integer> doubled = _numbers.stream()
                .map(lambda)
                .collect(Collectors.toList());

        System.out.println("Map by Function: " + doubled);

        // how to create Function from method reference.
        List<Double> numbers = Arrays.asList(1D, 25D, 100D);

        System.out.println("Create Function from method reference: " + transformNumbers(numbers, Math::sqrt));

    }

    private static List<String> transformNumbers(List<Double> numbers, Function<Double, Double> fx) {
        return numbers.stream()
                    .map(x -> String.valueOf(fx.apply(x)))
                    .collect(Collectors.toList());
    }

}

class Calculator {
    public String calc(BiFunction<Integer, Integer, String> bi, Integer i1, Integer i2) {
        return bi.apply(i1, i2);
    }
}



