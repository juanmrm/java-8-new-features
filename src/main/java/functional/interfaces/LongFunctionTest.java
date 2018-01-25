package functional.interfaces;

import java.util.function.LongFunction;

class LongFunctionTest {

    public static void main(String[] args) {
        LongFunction<String> i = (l) -> Long.toString(l);

        System.out.println(i.apply(Long.MAX_VALUE));
    }

}
