package functional.interfaces;

import java.util.function.DoubleFunction;

class DoubleFunctionTest {

    public static void main(String[] args) {
        DoubleFunction<String> df = (d) -> d +" is now a string";

        System.out.println(df.apply(0.5));
    }

}
