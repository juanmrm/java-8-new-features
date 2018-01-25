package functional.interfaces;

import java.util.function.Function;

class FunctionTest {

    public static void main(String[] args) {
        Function<Integer,String> converter = (i)-> Integer.toString(i);

        System.out.println(converter.apply(3).length());
        System.out.println(converter.apply(30).length());

        // how to pass Function as parameter.
        String result = calc((a) -> "Result: " + (a * 2), 10);
        System.out.println(result);

    }

    static String calc(Function<Integer, String> bi, Integer i) {
        return bi.apply(i);
    }

}
