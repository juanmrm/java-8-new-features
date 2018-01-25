package functional.interfaces;

import java.util.function.IntFunction;

class IntFunctionTest {

    public static void main(String[] args) {
        IntFunction<String> i = (x) -> Integer.toString(x);

        System.out.println(i.apply(3).length());
    }

}
