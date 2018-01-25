package functional.interfaces;

import java.util.function.LongFunction;

class LongFunctionTest {

    public static void main(String[] args) {
        LongFunction<String> i = Long::toString;

        System.out.println(i.apply(Long.MAX_VALUE));
    }

}
